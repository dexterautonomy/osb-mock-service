package com.techm.devops.dto.ss.ocs.querybalance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QueryBalanceResult {

    @JsonProperty("AcctList")
    public AcctList acctList = new AcctList();

}