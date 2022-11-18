package com.techm.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class CustInfo {

    @JsonProperty("CustType")
    public String custType="23456789";
    @JsonProperty("CustNodeType")
    public String custNodeType="23456789";
    @JsonProperty("CustClass")
    public String custClass="23456789";
    @JsonProperty("CustCode")
    public String custCode="23456789";
    @JsonProperty("CustBasicInfo")
    public CustBasicInfo custBasicInfo=new CustBasicInfo();

}


