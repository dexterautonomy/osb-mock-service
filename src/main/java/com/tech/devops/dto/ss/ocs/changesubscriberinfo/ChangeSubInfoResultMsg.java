package com.tech.devops.dto.ss.ocs.changesubscriberinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class ChangeSubInfoResultMsg {

    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader = new ResultHeader();

}