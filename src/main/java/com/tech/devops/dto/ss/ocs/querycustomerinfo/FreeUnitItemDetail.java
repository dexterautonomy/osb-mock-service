package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FreeUnitItemDetail {

    @JsonProperty("FreeUnitInstanceID")
    public String freeUnitInstanceID;
    @JsonProperty("InitialAmount")
    public String initialAmount;
    @JsonProperty("CurrentAmount")
    public String currentAmount;
    @JsonProperty("EffectiveTime")
    public String effectiveTime;
    @JsonProperty("ExpireTime")
    public String expireTime;
    @JsonProperty("FreeUnitOrigin")
    public FreeUnitOrigin freeUnitOrigin;
    @JsonProperty("RollOverFlag")
    public String rollOverFlag;
    @JsonProperty("LastRollOveredTime")
    public String lastRollOveredTime;

}
