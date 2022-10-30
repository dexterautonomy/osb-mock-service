package com.techm.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("getaccountholderinforequest")
public class MobileMoneyRegistrationInfoRequestDTO {
    @JsonProperty("identity")
    public String identity;
}