package com.tech.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class MessageBody {
    @JsonProperty("ID")
    public String id = "123456789wertyuio";
    @JsonProperty("Serial")
    public String serial = "12345678900987654321234567890-0987654";
    @JsonProperty("RetCode")
    public String retCode = "U000";
    @JsonProperty("RetDesc")
    public String retDesc = "This is a description";
    @JsonProperty("RetParaList")
    public List<Object> retParaList = new ArrayList<>();
}