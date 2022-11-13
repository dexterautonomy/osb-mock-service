package com.techm.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MessageBody {
    @JsonProperty("ID")
    public String id;
    @JsonProperty("Serial")
    public String serial;
    @JsonProperty("RetCode")
    public String retCode;
    @JsonProperty("RetDesc")
    public String retDesc;
    @JsonProperty("RetParaList")
    public List<Object> retParaList = null;
}