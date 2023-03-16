package com.techm.devops.dto.ben;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.bn.Value;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Param {
    @JsonProperty("value")
    public Value_5 value;
}