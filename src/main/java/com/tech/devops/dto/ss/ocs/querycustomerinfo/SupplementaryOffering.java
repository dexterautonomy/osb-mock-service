package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SupplementaryOffering {

    @JsonProperty("OfferingKey")
    public OfferingKey__1 offeringKey=new OfferingKey__1();
    @JsonProperty("BundledFlag")
    public String bundledFlag="23456789";
    @JsonProperty("OfferingClass")
    public String offeringClass="23456789";
    @JsonProperty("Status")
    public String status="23456789";
    @JsonProperty("TrialStartTime")
    public String trialStartTime="23456789";
    @JsonProperty("TrialEndTime")
    public String trialEndTime="23456789";
    @JsonProperty("EffectiveTime")
    public String effectiveTime="23456789";
    @JsonProperty("ExpirationTime")
    public String expirationTime="23456789";
    @JsonProperty("ActivationMode")
    public String activationMode="23456789";
    @JsonProperty("ActivationTime")
    public String activationTime="23456789";

}
