package com.techm.devops.dto.ss.ocs.suboffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OfferingKey {

    @JsonProperty("OfferingID")
    public String offeringID = "ID-112";
    @JsonProperty("PurchaseSeq")
    public String purchaseSeq = "123456789098765";

}