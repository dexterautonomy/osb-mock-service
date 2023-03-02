package com.techm.devops.dto.ss.ocs.queryfreelimit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {

    @JsonProperty("QueryFreeUnitResultMsg")
    private QueryFreeUnitResultMsg queryFreeUnitResultMsg = new QueryFreeUnitResultMsg();
}
