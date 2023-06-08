package com.tech.devops.dto.ss.ocs.subscriberidentifier;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tech.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class ChangeSubIdentityResultMsg {
    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader = new ResultHeader();
}
