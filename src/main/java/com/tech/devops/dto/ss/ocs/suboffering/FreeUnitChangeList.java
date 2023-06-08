package com.tech.devops.dto.ss.ocs.suboffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FreeUnitChangeList {

    @JsonProperty("OwnerType")
    public String ownerType = "BOSS";
    @JsonProperty("OwnerKey")
    public String ownerKey = "BossKEY";
    @JsonProperty("FreeUnitChgInfo")
    public FreeUnitChgInfo freeUnitChgInfo = new FreeUnitChgInfo();

}