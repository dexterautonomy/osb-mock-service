package com.techm.devops.dto.ss.ocs.creditlimitchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreditLimit {

    @JsonProperty("CreditInstID")
    public String creditInstID = "1234567898";
    @JsonProperty("LimitClass")
    public String limitClass = "Limitless";
    @JsonProperty("Amount")
    public String amount = "Flenty muoney";
    @JsonProperty("EffectiveTime")
    public String effectiveTime = "12345678909876543";
    @JsonProperty("ExpireTime")
    public String expireTime = "12345678907890";

}