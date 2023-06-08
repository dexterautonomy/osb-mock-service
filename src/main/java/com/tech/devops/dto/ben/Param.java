package com.tech.devops.dto.ben;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Param {
    @JsonProperty("value")
    public Value_5 value;
}