package org.example.dto.position;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PositionDTO {
    @JsonProperty("role")
    String primaryRole;
    @JsonProperty("primarySkill")
    PrimarySkillDTO primarySkill;
    @JsonProperty("seniority")
    SeniorityDTO seniorityLvl;
    @JsonProperty("niceOrMustSkills")
    List<SkillDTO> skills;
    @JsonProperty("locations")
    List<LocationDTO> positionLocations;
    @JsonProperty("billingType")
    String positionBillingType;
    @JsonProperty("staffingCommitmentType")
    StaffingCommitmentTypeDTO staffingCommitmentTypeDTO;
    @JsonProperty("containerDomain")
    String domain;
    @JsonProperty("containerCode")
    String projectCode;
    @JsonProperty("creationDate")
    long creationDate;
}
