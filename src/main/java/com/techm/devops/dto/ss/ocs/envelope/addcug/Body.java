package com.techm.devops.dto.ss.ocs.envelope.addcug;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.cugsubscription.AddGroupMemberResultMsg;

public class Body {
    @JsonProperty("AddGroupMemberResultMsg")
    public AddGroupMemberResultMsg addGroupMemberResultMsg = new AddGroupMemberResultMsg();
}