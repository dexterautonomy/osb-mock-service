package com.techm.devops.dto.ss.ocs.creditlimitchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreditLimit {

    @JsonProperty("CreditInstID")
    public String creditInstID;
    @JsonProperty("LimitClass")
    public String limitClass;
    @JsonProperty("Amount")
    public String amount;
    @JsonProperty("EffectiveTime")
    public String effectiveTime;
    @JsonProperty("ExpireTime")
    public String expireTime;

}