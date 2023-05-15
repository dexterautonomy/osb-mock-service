package com.techm.devops.dto.ss.ocs.querybalance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AcctList {
    @JsonProperty("AcctKey")
    public String acctKey = "63836442";
    @JsonProperty("BalanceResult")
    public BalanceResult balanceResult = new BalanceResult();
    @JsonProperty("AccountCredit")
    public AccountCredit accountCredit = new AccountCredit();
}