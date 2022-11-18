package com.techm.devops.dto.ss.ocs.querybalance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BalanceDetail {

    @JsonProperty("BalanceInstanceID")
    public String balanceInstanceID = "ytedfve256527t3gy8b3dew";
    @JsonProperty("Amount")
    public String amount = "234567890-";
    @JsonProperty("InitialAmount")
    public String initialAmount = "6789054321";
    @JsonProperty("EffectiveTime")
    public String effectiveTime = "23456789";
    @JsonProperty("ExpireTime")
    public String expireTime = "4567890";

    @JsonProperty("LastUpdateTime")
    public String lastUpdateTime="123456789098765";
}