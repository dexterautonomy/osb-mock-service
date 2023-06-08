package com.tech.devops.dto.ss.ocs.creditlimitchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("ChangeAcctCreditLimitResultMsg")
    private ChangeAcctCreditLimitResultMsg changeAcctCreditLimitResultMsg = new ChangeAcctCreditLimitResultMsg();
}