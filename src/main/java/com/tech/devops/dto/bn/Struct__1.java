package com.tech.devops.dto.bn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Struct__1 {
    @JsonProperty("name")
    public String name = "Laptop 1";
    @JsonProperty("value")
    public Value__2 value = new Value__2();
}