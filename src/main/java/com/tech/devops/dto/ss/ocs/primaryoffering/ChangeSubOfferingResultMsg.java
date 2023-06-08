package com.tech.devops.dto.ss.ocs.primaryoffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class ChangeSubOfferingResultMsg {

    @JsonProperty("ResultHeader")
    private ResultHeader resultHeader = new ResultHeader();

}