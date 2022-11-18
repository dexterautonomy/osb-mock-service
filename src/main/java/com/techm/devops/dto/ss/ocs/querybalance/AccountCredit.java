package com.techm.devops.dto.ss.ocs.querybalance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountCredit {

    @JsonProperty("TotalCreditAmount")
    public String totalCreditAmount = "1234567890";
    @JsonProperty("TotalUsageAmount")
    public String totalUsageAmount = "123456789";
    @JsonProperty("TotalRemainAmount")
    public String totalRemainAmount = "567890987654";
    @JsonProperty("CurrencyID")
    public String currencyID = "USD";

}