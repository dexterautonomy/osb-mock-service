package com.techm.devops.dto.ss.ocs.changesubstatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class ChangeSubStatusResultMsg {

    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader = new ResultHeader();
    @JsonProperty("ChangeSubStatusResult")
    public ChangeSubStatusResult changeSubStatusResult = new ChangeSubStatusResult();

}