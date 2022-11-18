package com.techm.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FreeUnitOrigin {

    @JsonProperty("OriginType")
    public String originType;
    @JsonProperty("OfferingKey")
    public OfferingKey__2 offeringKey;

}
