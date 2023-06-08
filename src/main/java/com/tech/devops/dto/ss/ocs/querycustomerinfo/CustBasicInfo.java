package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustBasicInfo {

    @JsonProperty("CustSegment")
    public String custSegment="23456789";
    @JsonProperty("DFTWrittenLang")
    public String dFTWrittenLang="23456789";
    @JsonProperty("DFTIVRLang")
    public String dFTIVRLang="23456789";
    @JsonProperty("DFTBillCycleType")
    public String dFTBillCycleType="23456789";
    @JsonProperty("DFTCurrencyID")
    public String dFTCurrencyID="23456789";
    @JsonProperty("CustLevel")
    public String custLevel="23456789";
    @JsonProperty("CustLoyalty")
    public String custLoyalty="23456789";
    @JsonProperty("DunningFlag")
    public String dunningFlag="23456789";
    @JsonProperty("CustProperty")
    public List<CustProperty> custProperty = new ArrayList<>();

}