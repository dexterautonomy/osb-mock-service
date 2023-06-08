package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CustInfo__1 {

    @JsonProperty("CustType")
    public String custType;
    @JsonProperty("CustNodeType")
    public String custNodeType;
    @JsonProperty("CustClass")
    public String custClass;
    @JsonProperty("CustCode")
    public String custCode;
    @JsonProperty("CustBasicInfo")
    public CustBasicInfo__1 custBasicInfo;

}
