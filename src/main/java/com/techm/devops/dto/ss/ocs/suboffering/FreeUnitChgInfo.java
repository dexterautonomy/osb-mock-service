package com.techm.devops.dto.ss.ocs.suboffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FreeUnitChgInfo {

    @JsonProperty("FreeUnitInstanceID")
    public String freeUnitInstanceID = "Free123";
    @JsonProperty("FreeUnitType")
    public String freeUnitType = "FREeDOM";
    @JsonProperty("FreeUnitTypeName")
    public String freeUnitTypeName = "3456789";
    @JsonProperty("MeasureUnit")
    public String measureUnit = "metres";
    @JsonProperty("MeasureUnitName")
    public String measureUnitName = "metre name";
    @JsonProperty("OldAmt")
    public String oldAmt = "1000m";
    @JsonProperty("NewAmt")
    public String newAmt ="1 million metre";

}