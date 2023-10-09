package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.client.PositionClient;
import org.example.client.PostFeignClient;
import org.example.dto.position.PositionDTO;
import org.example.dto.position.ResponseDTO;
import org.example.dto.search.FilterItemDTO;
import org.example.dto.search.PositionRequestDTO;
import org.example.dto.search.SearchDto;
import org.example.dto.search.ValueDTO;
import org.example.filters.CreationDateFilter;
import org.example.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class PositionService {
    public PostFeignClient client;
    public PositionClient positionClient;
    public ObjectMapper mapper;
    private EmailServiceImpl emailService;
    public boolean isJobEnabled;
    public String cookie;

    @Autowired
    public PositionService(EmailServiceImpl emailService,
                           PostFeignClient client,
                           PositionClient positionClient,
                           ObjectMapper mapper) {
        this.emailService = emailService;
        this.client = client;
        this.positionClient = positionClient;
        this.mapper = mapper;
    }

    @Scheduled(fixedRate = 1800000)
    public void callClient() {


        if (isJobEnabled && cookie != null) {
            try {
                log.info("Job started");
                SearchDto searchDto = client.getSearchDto(cookie);
                PositionRequestDTO preRequest = PositionRequestDTO.builder().searchDto(searchDto).build();
                PositionRequestDTO requestToRadar = changeCreationDateRequest(preRequest);
                String search = mapper.writeValueAsString(requestToRadar);
                System.out.println(search);
                ResponseDTO positions = positionClient.getPositions(cookie, search);
                log.info("{} positions was received", positions.getPositions().size());
                List<PositionDTO> filteredPositions = CreationDateFilter.filterPositionByTime(positions);
                log.info("{} position left after filtration", filteredPositions.size());
                String[] allAddresses = emailService.getEmailAddresses();
                log.info("{} email addresses", allAddresses);
                emailService.sendMail(allAddresses, MailUtil.FROM_EMAIL, MailUtil.MAIL_SUBJECT, filteredPositions);
            } catch (Exception e) {
                log.error("Job was failed due to {}", e.getMessage());
            }

        } else {
            log.info("Job is disabled");
        }
    }

    public PositionRequestDTO changeCreationDateRequest(PositionRequestDTO requestDTO) {
        List<FilterItemDTO> itemsWithoutCreationFilter = requestDTO.getSearchDto().getData().getFilters().getItems().stream()
                .filter(item -> !item.getName().equals("creationDate"))
                .collect(Collectors.toList());
        ValueDTO sinceValue = ValueDTO.builder().displayName("Today")
                .quantity(0)
                .sinceOrTill("since")
                .tense(0)
                .type("Day")
                .operator(2)
                .build();

        ValueDTO tillValue = ValueDTO.builder().displayName("Today")
                .quantity(0)
                .sinceOrTill("till")
                .tense(0)
                .type("Day")
                .operator(3)
                .build();


        FilterItemDTO creationDateFilter = FilterItemDTO.builder().disabled(false)
                .name("creationDate")
                .values(List.of(sinceValue, tillValue))
                .mode(1)
                .settings(new HashMap<String, Object>())
                .build();

        itemsWithoutCreationFilter.add(creationDateFilter);

        requestDTO.getSearchDto().getData().getFilters().setItems(itemsWithoutCreationFilter);

        return requestDTO;
    }

    public void enableJob() {
        isJobEnabled = isJobEnabled ? false : true;
        log.info("Job new status {}", isJobEnabled);
    }
}
