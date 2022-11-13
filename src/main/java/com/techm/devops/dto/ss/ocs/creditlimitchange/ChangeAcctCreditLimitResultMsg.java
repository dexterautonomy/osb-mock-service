package com.techm.devops.dto.ss.ocs.creditlimitchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class ChangeAcctCreditLimitResultMsg {

    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader = new ResultHeader();
    @JsonProperty("ChangeAcctCreditLimitResult")
    public ChangeAcctCreditLimitResult changeAcctCreditLimitResult = new ChangeAcctCreditLimitResult();

}