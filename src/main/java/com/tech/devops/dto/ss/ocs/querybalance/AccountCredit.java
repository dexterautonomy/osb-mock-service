package com.tech.devops.dto.ss.ocs.querybalance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountCredit {
    @JsonProperty("CreditLimitType")
    public String creditLimitType = "C_INITIAL_CREDIT_LIMIT";
    @JsonProperty("CreditLimitTypeName")
    public String creditLimitTypeName = "InitialAcctCreditLimit";
    @JsonProperty("TotalCreditAmount")
    public String totalCreditAmount = "1234567890";
    @JsonProperty("TotalUsageAmount")
    public String totalUsageAmount = "123456789";
    @JsonProperty("TotalRemainAmount")
    public String totalRemainAmount = "567890987654";
    @JsonProperty("CurrencyID")
    public String currencyID = "1185";
    @JsonProperty("CreditAmountInfo")
    public CreditAmountInfo creditAmountInfo = new CreditAmountInfo();
    @JsonProperty("NoLimitFlag")
    public String noLimitFlag = "N";
}