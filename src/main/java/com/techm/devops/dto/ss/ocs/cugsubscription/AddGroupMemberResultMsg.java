package com.techm.devops.dto.ss.ocs.cugsubscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class AddGroupMemberResultMsg {

    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader = new ResultHeader();

}

