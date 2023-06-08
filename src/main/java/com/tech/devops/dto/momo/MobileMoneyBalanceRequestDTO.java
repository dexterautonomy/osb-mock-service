package com.tech.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("getbalancerequest")
public class MobileMoneyBalanceRequestDTO {
    @JsonProperty("fri")
    public String fri;
}
