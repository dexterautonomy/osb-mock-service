package com.tech.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("getbalanceresponse")
public class MobileMoneyBalanceResponseDTO {
    @JsonProperty("balance")
    public Balance balance = new Balance();
}
