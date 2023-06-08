package com.tech.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("SendSyncReqResponse")
    private SendSyncReqResponse sendSyncReqResponse = new SendSyncReqResponse();
}