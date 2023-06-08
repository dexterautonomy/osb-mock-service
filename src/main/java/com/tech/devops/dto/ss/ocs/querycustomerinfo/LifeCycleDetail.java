package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class LifeCycleDetail {

    @JsonProperty("StatusDetail")
    public String statusDetail;
    @JsonProperty("FraudTimes")
    public String fraudTimes;
    @JsonProperty("RBlacklistStatus")
    public String rBlacklistStatus;
    @JsonProperty("CurrentStatusIndex")
    public String currentStatusIndex;
    @JsonProperty("LifeCycleStatus")
    public List<LifeCyclestatus> lifeCycleStatus = null;

}
