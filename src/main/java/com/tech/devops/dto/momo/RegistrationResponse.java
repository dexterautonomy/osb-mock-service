package com.tech.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
@Data
@JsonRootName("registrationresponse")
public class RegistrationResponse {
    @JsonProperty("accountholderidentity")
    private String accountholderidentity = "FRI:691002/ID";
}