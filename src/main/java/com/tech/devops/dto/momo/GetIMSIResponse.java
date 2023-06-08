package com.tech.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("getaccountholderimsiresponse")
public class GetIMSIResponse {
    @JsonProperty("imsi")
    private String imsi = "123456789067890";
}
