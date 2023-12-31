package org.example.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.dto.search.ColumnValueDTO;

import java.util.List;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class TooltipOptionsDTO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("title")
    private String title;

    @JsonProperty("type")
    private String type;

    @JsonProperty("values")
    private List<ColumnValueDTO> values;
}
