package com.techm.devops.dto.ss.ocs.suboffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AcctBalanceChangeList {

    @JsonProperty("AcctKey")
    public String acctKey = "Key1";
    @JsonProperty("BalanceChgInfo")
    public BalanceChgInfo balanceChgInfo = new BalanceChgInfo();

}