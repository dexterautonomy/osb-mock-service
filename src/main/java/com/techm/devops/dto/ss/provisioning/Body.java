package com.techm.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.creditlimitchange.ChangeAcctCreditLimitResultMsg;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("SendSyncReqResponse")
    private SendSyncReqResponse sendSyncReqResponse = new SendSyncReqResponse();
}