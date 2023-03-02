package com.techm.devops.dto.ss.ocs.cugsubscription.removecug;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class DelGroupMemberResultMsg {

    @JsonProperty("ResultHeader")
    private ResultHeader resultHeader = new ResultHeader();

}