package com.techm.devops.dto.ss.ocs.suboffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BalanceChgInfo {

    @JsonProperty("BalanceType")
    public String balanceType = "Credit";
    @JsonProperty("BalanceID")
    public String balanceID = "WERSV12345678";
    @JsonProperty("BalanceTypeName")
    public String balanceTypeName = "TooMuchMoney";
    @JsonProperty("OldBalanceAmt")
    public String oldBalanceAmt = "100000000";
    @JsonProperty("NewBalanceAmt")
    public String newBalanceAmt = "8922019273";
    @JsonProperty("CurrencyID")
    public String currencyID = "Dollars";

}