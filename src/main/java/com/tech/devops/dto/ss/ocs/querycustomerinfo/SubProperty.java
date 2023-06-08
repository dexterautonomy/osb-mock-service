package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubProperty {

    @JsonProperty("Code")
    public String code;
    @JsonProperty("Value")
    public String value;

}
