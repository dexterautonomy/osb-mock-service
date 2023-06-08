package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MemberUsageList {

    @JsonProperty("PrimaryIdentity")
    public String primaryIdentity;
    @JsonProperty("SubscriberKey")
    public String subscriberKey;
    @JsonProperty("UsedAmount")
    public String usedAmount;

}
