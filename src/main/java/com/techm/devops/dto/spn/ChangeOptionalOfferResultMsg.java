package com.techm.devops.dto.spn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChangeOptionalOfferResultMsg {
    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader = new ResultHeader();
}