package com.techm.devops.dto.ss.ocs.suboffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RentDeductionResult {

    @JsonProperty("AcctBalanceChangeList")
    public AcctBalanceChangeList acctBalanceChangeList = new AcctBalanceChangeList();
    @JsonProperty("FreeUnitChangeList")
    public FreeUnitChangeList freeUnitChangeList = new FreeUnitChangeList();

}