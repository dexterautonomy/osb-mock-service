package com.techm.devops.dto.ss.ocs.subdeactivation;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultHeader {

    @JsonProperty("Version")
    public String version = "1000";
    @JsonProperty("ResultCode")
    public String resultCode = "1000";
    @JsonProperty("ResultDesc")
    public String resultDesc = "Operation successful";

}