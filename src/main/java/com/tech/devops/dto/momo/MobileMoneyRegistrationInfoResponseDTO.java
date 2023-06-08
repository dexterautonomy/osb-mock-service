package com.tech.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("getaccountholderinforesponse")
public class MobileMoneyRegistrationInfoResponseDTO {
    @JsonProperty("accountholderbasicinfo")
    public Accountholderbasicinfo accountholderbasicinfo = new Accountholderbasicinfo();
    @JsonProperty("credentialslist")
    public Credentialslist credentialslist = new Credentialslist();
}
