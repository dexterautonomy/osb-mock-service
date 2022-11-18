package com.techm.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OfferingKey__2 {

    @JsonProperty("OfferingID")
    public String offeringID;
    @JsonProperty("PurchaseSeq")
    public String purchaseSeq;
    @JsonProperty("OfferingName")
    public String offeringName;

}
