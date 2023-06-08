package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CustBasicInfo__2 {

    @JsonProperty("CustSegment")
    public String custSegment;
    @JsonProperty("DFTWrittenLang")
    public String dFTWrittenLang;
    @JsonProperty("DFTIVRLang")
    public String dFTIVRLang;
    @JsonProperty("DFTBillCycleType")
    public String dFTBillCycleType;
    @JsonProperty("DFTCurrencyID")
    public String dFTCurrencyID;
    @JsonProperty("CustLevel")
    public String custLevel;
    @JsonProperty("CustLoyalty")
    public String custLoyalty;
    @JsonProperty("DunningFlag")
    public String dunningFlag;
    @JsonProperty("CustProperty")
    public List<CustProperty> custProperty = null;

}