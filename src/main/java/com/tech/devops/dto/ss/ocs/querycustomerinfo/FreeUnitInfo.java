package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FreeUnitInfo {

    @JsonProperty("FreeUnitType")
    public String freeUnitType;
    @JsonProperty("FreeUnitTypeName")
    public String freeUnitTypeName;
    @JsonProperty("MeasureUnit")
    public String measureUnit;
    @JsonProperty("MeasureUnitName")
    public String measureUnitName;
    @JsonProperty("TotalInitialAmount")
    public String totalInitialAmount;
    @JsonProperty("TotalUnusedAmount")
    public String totalUnusedAmount;
    @JsonProperty("FreeUnitItemDetail")
    public FreeUnitItemDetail freeUnitItemDetail;
    @JsonProperty("MemberUsageList")
    public MemberUsageList memberUsageList;

}
