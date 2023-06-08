package com.tech.devops.dto.ss.ocs.queryfreelimit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QueryFreeUnitResult {

    @JsonProperty("FreeUnitItem")
    public FreeUnitItem freeUnitItem = new FreeUnitItem();

}