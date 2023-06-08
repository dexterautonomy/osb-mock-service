package com.tech.devops.dto.bn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Params {
    @JsonProperty("param")
    public Param param = new Param();
}