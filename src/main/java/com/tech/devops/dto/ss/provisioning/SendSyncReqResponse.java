package com.tech.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data

@JsonRootName(value = "SendSyncReqResponse", namespace = "http://huawei.com/mds/access/webservice/server/bean")
public class SendSyncReqResponse {

    @JsonProperty("SyncRequestResult")
    public SyncRequestResult syncRequestResult = new SyncRequestResult();

}