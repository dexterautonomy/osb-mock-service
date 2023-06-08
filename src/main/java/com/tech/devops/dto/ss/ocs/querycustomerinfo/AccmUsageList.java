package com.tech.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccmUsageList {

    @JsonProperty("AccmType")
    public String accmType;
    @JsonProperty("AccmTypeName")
    public String accmTypeName;
    @JsonProperty("Amount")
    public String amount;
    @JsonProperty("UnitType")
    public String unitType;
    @JsonProperty("CurrencyID")
    public String currencyID;
    @JsonProperty("BeginDate")
    public String beginDate;
    @JsonProperty("EndDate")
    public String endDate;

}