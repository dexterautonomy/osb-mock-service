package com.techm.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Newbalance {
    @JsonProperty("amount")
    public String amount = "5000";
    @JsonProperty("currency")
    public String currency = "USD";
}
