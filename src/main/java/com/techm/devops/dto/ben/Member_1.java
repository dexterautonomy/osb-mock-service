package com.techm.devops.dto.ben;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName(value = "member")
public class Member_1 {
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private Value_1 val;
}
