package com.techm.devops.dto.ss.ocs.creditlimitchange;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreditLimit {

    @JsonProperty("CreditInstID")
    public String creditInstID = "1234567898";
    @JsonProperty("LimitClass")
    public String limitClass = "Limitless";
    @JsonProperty("Amount")
    public BigDecimal amount = new BigDecimal(1000);
    @JsonProperty("EffectiveTime")
    public String effectiveTime = "12345678909876543";
    @JsonProperty("ExpireTime")
    public String expireTime = "12345678907890";

}