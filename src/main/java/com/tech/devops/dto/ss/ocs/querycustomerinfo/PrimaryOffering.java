package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PrimaryOffering {

    @JsonProperty("OfferingKey")
    public OfferingKey offeringKey;
    @JsonProperty("BundledFlag")
    public String bundledFlag;
    @JsonProperty("OfferingClass")
    public String offeringClass;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("ProductInst")
    public ProductInst productInst;

}
