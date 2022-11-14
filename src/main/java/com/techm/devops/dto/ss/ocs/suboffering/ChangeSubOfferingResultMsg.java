package com.techm.devops.dto.ss.ocs.suboffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class ChangeSubOfferingResultMsg {

    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader = new ResultHeader();
    @JsonProperty("ChangeSubOfferingResult")
    public ChangeSubOfferingResult changeSubOfferingResult = new ChangeSubOfferingResult();

}