package com.techm.devops.dto.ss.ocs.subscriberidentifier;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class ChangeSubIdentityResultMsg {
    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader = new ResultHeader();
}
