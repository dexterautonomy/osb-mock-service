package com.techm.devops.dto.ss.ocs.queryfreelimit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FreeUnitItem {

    @JsonProperty("FreeUnitType")
    public String freeUnitType="FREE";
    @JsonProperty("FreeUnitTypeName")
    public String freeUnitTypeName="DOM";
    @JsonProperty("MeasureUnit")
    public String measureUnit="Money";
    @JsonProperty("MeasureUnitName")
    public String measureUnitName="Ego";
    @JsonProperty("TotalInitialAmount")
    public String totalInitialAmount="Owo";
    @JsonProperty("TotalUnusedAmount")
    public String totalUnusedAmount="12345678";

}