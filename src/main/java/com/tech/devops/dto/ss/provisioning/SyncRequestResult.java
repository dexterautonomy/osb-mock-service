package com.tech.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SyncRequestResult {

    @JsonProperty("ResultMessage")
    public ResultMessage resultMessage = new ResultMessage();

}