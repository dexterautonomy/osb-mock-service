package com.techm.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class IndividualProperty {

    @JsonProperty("Code")
    public String code;
    @JsonProperty("Value")
    public String value;

}
