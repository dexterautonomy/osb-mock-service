package com.techm.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Customer {

    @JsonProperty("CustKey")
    public String custKey="23456789";
    @JsonProperty("CustInfo")
    public CustInfo custInfo=new CustInfo();
    @JsonProperty("IndividualInfo")
    public IndividualInfo individualInfo=new IndividualInfo();
    @JsonProperty("AddressInfo")
    public AddressInfo addressInfo=new AddressInfo();

}
