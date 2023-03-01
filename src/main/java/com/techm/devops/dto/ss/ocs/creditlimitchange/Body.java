package com.techm.devops.dto.ss.ocs.creditlimitchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.suboffering.ChangeSubOfferingResultMsg;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("ChangeAcctCreditLimitResultMsg")
    private ChangeAcctCreditLimitResultMsg changeAcctCreditLimitResultMsg = new ChangeAcctCreditLimitResultMsg();
}