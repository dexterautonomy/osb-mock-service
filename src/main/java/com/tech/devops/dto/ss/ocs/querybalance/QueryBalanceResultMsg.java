package com.tech.devops.dto.ss.ocs.querybalance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class QueryBalanceResultMsg {

    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader = new ResultHeader();
    @JsonProperty("QueryBalanceResult")
    public QueryBalanceResult queryBalanceResult = new QueryBalanceResult();

}