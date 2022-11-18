package com.techm.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AcctBasicInfo {

    @JsonProperty("AcctName")
    public String acctName;
    @JsonProperty("BillLang")
    public String billLang;
    @JsonProperty("DunningFlag")
    public String dunningFlag;
    @JsonProperty("LateFeeChargeable")
    public String lateFeeChargeable;
    @JsonProperty("RedlistFlag")
    public String redlistFlag;
    @JsonProperty("ContactInfo")
    public ContactInfo contactInfo;
    @JsonProperty("AcctProperty")
    public List<AcctProperty> acctProperty = null;

}