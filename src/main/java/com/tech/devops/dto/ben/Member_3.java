package com.tech.devops.dto.ben;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Member_3 {
    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private Value_3 val;
}
