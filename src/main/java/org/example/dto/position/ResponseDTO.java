package org.example.dto.position;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Setter
public class ResponseDTO {
    @JsonProperty("entities")
    List<PositionDTO> positions;
}
