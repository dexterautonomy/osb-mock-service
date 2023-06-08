package com.tech.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Fromavailablebalance {
    @JsonProperty("amount")
    public String amount = "1000";
    @JsonProperty("currency")
    public String currency = "USD";
}
