package com.techm.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SendSyncReqResponse {

    @JsonProperty("SyncRequestResult")
    public SyncRequestResult syncRequestResult;

}