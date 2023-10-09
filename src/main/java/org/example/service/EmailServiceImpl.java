package org.example.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.position.PositionDTO;
import org.example.dto.position.SkillDTO;
import org.example.entity.MailAddress;
import org.example.repository.MailAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmailServiceImpl {
    private JavaMailSender sender;
    private SpringTemplateEngine templateEngine;
    private MailAddressRepository repository;

    @Autowired
    public EmailServiceImpl(JavaMailSender sender, SpringTemplateEngine templateEngine, MailAddressRepository repository) {
        this.sender = sender;
        this.templateEngine = templateEngine;
        this.repository = repository;
    }

    public void sendMail(String[] toAddresses, String from, String subject, List<PositionDTO> positionDTO) {
        if (positionDTO.isEmpty()) {
            log.info("No positions to send");
            return;
        }
        MimeMessage mailMessage = sender.createMimeMessage();
        String mailText = createMailText(positionDTO);
        log.info("Email configuration: from {}, subject {}, addresses{}", from, subject, toAddresses);
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mailMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            helper.setFrom(from);
            helper.setTo(toAddresses);
            helper.setSubject(subject);
            helper.setText(mailText, true);
            sender.send(mailMessage);
            log.info("Email was successfully sent");
        } catch (MessagingException e) {
            log.error("Email wasn't sent due to {}", e.getMessage());
        }
    }

    public String createMailText(List<PositionDTO> positions) {
        Map<String, Object> mailProperties = createMailProperties(positions);
        Context context = new Context();
        context.setVariables(mailProperties);
        return templateEngine.process("positionEmailTemplate", context);
    }

    private Map<String, Object> createMailProperties(List<PositionDTO> positionDTOs) {
        Map<String, Object> mailProperties = new HashMap<>();

        mailProperties.put("positions", positionDTOs);

        log.info("Mail properties {} created", mailProperties);

        return mailProperties;
    }

    private List<String> createListOfMustHaveSkills(List<SkillDTO> skillDTOList) {
        return skillDTOList.stream()
                .filter(skillDTO -> skillDTO.isMustHave())
                .map(skillDTO -> skillDTO.getFullName())
                .collect(Collectors.toList());
    }

    private List<String> createListOfNiceToHaveSkills(List<SkillDTO> skillDTOList) {
        return skillDTOList.stream()
                .filter(skillDTO -> !skillDTO.isMustHave())
                .map(skillDTO -> skillDTO.getFullName())
                .collect(Collectors.toList());
    }

    public String[] getEmailAddresses() {
        String[] allAddresses = repository.findAllAddresses();
        log.info("Get all email addresses {}", allAddresses);
        return allAddresses;
    }

    public void addEmailAddress(MailAddress mailAddress) {
        try {
            repository.save(mailAddress);
            log.info("Email address {} was saved", mailAddress);
        } catch (Exception e) {
            log.error("Email address {} wasn't saved", mailAddress);
        }
    }

    public void deleteEmailAddress(String mailAddress) {
        try {
            repository.deleteMailAddress(mailAddress);
            log.info("Email address {} was successfully deleted", mailAddress);
        } catch (Exception e) {
            log.error("Email address {} wasn't deleted due to {}", mailAddress, e.getMessage());
        }
    }

    public void updateEmailAddress(String mailAddress, MailAddress newMailAddress) {
        try {
            repository.updateMailAddress(mailAddress, newMailAddress.getMailAddress());
            log.info("Email address {} was successfully change to {}", mailAddress, newMailAddress);
        } catch (Exception e) {
            log.error("Email address{} wasn't updated due to {}", mailAddress, e.getMessage());
        }
    }


}
