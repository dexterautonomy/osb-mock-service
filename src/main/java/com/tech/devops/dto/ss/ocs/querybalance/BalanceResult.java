package com.tech.devops.dto.ss.ocs.querybalance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BalanceResult {

    @JsonProperty("BalanceType")
    public String balanceType="CREDIT";
    @JsonProperty("BalanceTypeName")
    public String balanceTypeName="CRED";
    @JsonProperty("TotalAmount")
    public String totalAmount="234567890";
    @JsonProperty("DepositFlag")
    public String depositFlag="D";
    @JsonProperty("RefundFlag")
    public String refundFlag="R";
    @JsonProperty("CurrencyID")
    public String currencyID="USD";
    @JsonProperty("BalanceDetail")
    public BalanceDetail balanceDetail = new BalanceDetail();

}