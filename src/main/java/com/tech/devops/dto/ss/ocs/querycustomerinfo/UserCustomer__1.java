package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserCustomer__1 {

    @JsonProperty("CustKey")
    public String custKey="ertyuiop";
    @JsonProperty("CustInfo")
    public CustInfo__2 custInfo=new CustInfo__2();
    @JsonProperty("IndividualInfo")
    public IndividualInfo__2 individualInfo=new IndividualInfo__2();

}
