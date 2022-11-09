package com.techm.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Newbalance {
    @JsonProperty("amount")
    public BigDecimal amount = new BigDecimal("5000");
    @JsonProperty("currency")
    public String currency = "USD";
}
