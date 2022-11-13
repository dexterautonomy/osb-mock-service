package com.techm.devops.dto.ss.ocs.subdeactivation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubDeactivationResultMsg {

    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader = new ResultHeader();

}