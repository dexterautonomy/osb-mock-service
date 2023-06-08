package com.tech.devops.dto.ss.ocs.suboffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddOffering {

    @JsonProperty("OfferingKey")
    public OfferingKey offeringKey = new OfferingKey();
    @JsonProperty("EffectiveTime")
    public String effectiveTime = "1234567890";
    @JsonProperty("ExpirationTime")
    public String expirationTime = "1234567890987654";
    @JsonProperty("RentDeductionStatus")
    public String rentDeductionStatus = "100 percent";

}