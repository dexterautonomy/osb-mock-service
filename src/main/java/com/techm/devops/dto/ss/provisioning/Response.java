package com.techm.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {
    @JsonProperty("SendSyncReqResponse")
    public SendSyncReqResponse sendSyncReqResponse;
}