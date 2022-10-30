package com.techm.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Credentials {
    @JsonProperty("credentialtype")
    public String credentialtype = "AuthType2.0";
    @JsonProperty("credentialstatus")
    public String credentialstatus = "Secured";
}
