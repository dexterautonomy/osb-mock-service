package com.techm.devops.dto.bn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    @JsonProperty("methodResponse")
    public MethodResponse methodResponse = new MethodResponse();
}