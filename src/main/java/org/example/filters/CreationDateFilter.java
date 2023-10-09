package org.example.filters;

import org.example.dto.position.PositionDTO;
import org.example.dto.position.ResponseDTO;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CreationDateFilter {
    public static List<PositionDTO> filterPositionByTime(ResponseDTO responseDto) {
        System.out.println("filter");
        responseDto.getPositions().stream().map(positionDTO -> positionDTO.getCreationDate()).forEach(System.out::println);
        System.out.println("-----");
        System.out.println(responseDto.getPositions().size());

        if (responseDto != null) {
            List<PositionDTO> filteredPosition = responseDto.getPositions().stream()
                    .filter(position -> System.currentTimeMillis() - position.getCreationDate() < 1800000)
                    .collect(Collectors.toList());
            System.out.println(filteredPosition.size());
            return filteredPosition;
        }
        return Collections.emptyList();
    }

}
