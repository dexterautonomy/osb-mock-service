package com.tech.devops.dto.bn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member {
    @JsonProperty("name")
    public String name = "Phone 1";
    @JsonProperty("value")
    public Value__1 value = new Value__1();
}