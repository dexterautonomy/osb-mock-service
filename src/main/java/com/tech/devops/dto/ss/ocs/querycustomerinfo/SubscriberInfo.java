package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubscriberInfo {

    @JsonProperty("SubBasicInfo")
    public SubBasicInfo subBasicInfo=new SubBasicInfo();
    @JsonProperty("UserCustomerKey")
    public String userCustomerKey;
    @JsonProperty("SubIdentity")
    public SubIdentity subIdentity=new SubIdentity();
    @JsonProperty("Brand")
    public String brand="23456789";
    @JsonProperty("SubClass")
    public String subClass="23456789";
    @JsonProperty("NetworkType")
    public String networkType="23456789";
    @JsonProperty("Status")
    public String status="23456789";
    @JsonProperty("ActiveTimeLimit")
    public String activeTimeLimit="23456789";
    @JsonProperty("StatusDetail")
    public String statusDetail="23456789";
    @JsonProperty("ActivationTime")
    public String activationTime="23456789";
    @JsonProperty("UserCustomer")
    public UserCustomer userCustomer=new UserCustomer();
    @JsonProperty("AddressInfo")
    public AddressInfo__1 addressInfo=new AddressInfo__1();

}
