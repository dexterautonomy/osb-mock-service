package com.techm.devops.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Fromcommittedbalance {
    @JsonProperty("amount")
    public String amount = "1000";
    @JsonProperty("currency")
    public String currency = "USD";
}
