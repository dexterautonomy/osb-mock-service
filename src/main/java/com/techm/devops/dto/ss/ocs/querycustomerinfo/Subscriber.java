package com.techm.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.querybalance.AcctList;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Subscriber {

    @JsonProperty("SubscriberKey")
    public String subscriberKey="23456789";
    @JsonProperty("SubscriberInfo")
    public SubscriberInfo subscriberInfo=new SubscriberInfo();
    @JsonProperty("PaymentMode")
    public String paymentMode="23456789";
    @JsonProperty("PrimaryOffering")
    public PrimaryOffering primaryOffering=new PrimaryOffering();
    @JsonProperty("SupplementaryOffering")
    public SupplementaryOffering supplementaryOffering=new SupplementaryOffering();
    @JsonProperty("AccmUsageList")
    public AccmUsageList accmUsageList;
    @JsonProperty("LifeCycleDetail")
    public LifeCycleDetail lifeCycleDetail;
    @JsonProperty("AcctList")
    public AcctList acctList;
    @JsonProperty("FreeUnitInfo")
    public List<FreeUnitInfo> freeUnitInfo = new ArrayList<>();

}
