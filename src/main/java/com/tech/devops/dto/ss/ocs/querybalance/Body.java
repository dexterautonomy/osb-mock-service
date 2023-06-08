package com.tech.devops.dto.ss.ocs.querybalance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("QueryBalanceResultMsg")
    private QueryBalanceResultMsg queryBalanceResultMsg = new QueryBalanceResultMsg();
}
