package com.tech.devops.dto.spn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Body {
    @JsonProperty("ChangeOptionalOfferResultMsg")
    public ChangeOptionalOfferResultMsg changeOptionalOfferResultMsg = new ChangeOptionalOfferResultMsg();
}