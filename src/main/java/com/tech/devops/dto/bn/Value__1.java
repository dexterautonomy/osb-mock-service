package com.tech.devops.dto.bn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Value__1 {
    @JsonProperty("struct")
    public List<Struct__1> struct = new ArrayList<>();
    @JsonProperty("string")
    public String string;
    @JsonProperty("i4")
    public String i4;
}