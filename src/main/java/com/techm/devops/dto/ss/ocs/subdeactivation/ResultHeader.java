package com.techm.devops.dto.ss.ocs.subdeactivation;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultHeader {

    @JsonProperty("Version")
    public String version;
    @JsonProperty("ResultCode")
    public String resultCode;
    @JsonProperty("ResultDesc")
    public String resultDesc;

}