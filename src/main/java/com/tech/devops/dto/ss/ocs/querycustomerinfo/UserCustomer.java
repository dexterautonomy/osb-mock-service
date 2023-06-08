package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserCustomer {

    @JsonProperty("CustKey")
    public String custKey="hjfkdlsflj";
    @JsonProperty("CustInfo")
    public CustInfo__1 custInfo=new CustInfo__1();
    @JsonProperty("IndividualInfo")
    public IndividualInfo__1 individualInfo=new IndividualInfo__1();

}
