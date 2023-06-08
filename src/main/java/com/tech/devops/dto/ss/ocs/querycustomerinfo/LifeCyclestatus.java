package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LifeCyclestatus {

    @JsonProperty("StatusName")
    public String statusName;
    @JsonProperty("StatusExpireTime")
    public String statusExpireTime;
    @JsonProperty("StatusIndex")
    public String statusIndex;

}
