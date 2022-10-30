package com.techm.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Balance {
    @JsonProperty("amount")
    public String amount = "50000000000";
    @JsonProperty("currency")
    public String currency = "USD";
}
