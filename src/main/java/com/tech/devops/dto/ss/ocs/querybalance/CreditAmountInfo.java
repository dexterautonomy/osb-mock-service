package com.tech.devops.dto.ss.ocs.querybalance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreditAmountInfo {
    @JsonProperty("CreditInstID")
    public String creditInstID = "127030";
    @JsonProperty("LimitClass")
    public String limitClass = "I";
    @JsonProperty("Amount")
    public String amount = "2500000000";
    @JsonProperty("EffectiveTime")
    public String effectiveTime = "20221216100622";
    @JsonProperty("ExpireTime")
    public String expireTime = "20221216100622";
}