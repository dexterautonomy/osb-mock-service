package com.techm.devops.dto.ss.ocs.queryfreelimit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class QueryFreeUnitResultMsg {

    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader = new ResultHeader();
    @JsonProperty("QueryFreeUnitResult")
    public QueryFreeUnitResult queryFreeUnitResult = new QueryFreeUnitResult();

}