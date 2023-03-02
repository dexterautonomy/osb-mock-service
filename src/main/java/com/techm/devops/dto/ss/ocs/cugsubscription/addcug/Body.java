package com.techm.devops.dto.ss.ocs.cugsubscription.addcug;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("AddGroupMemberResultMsg")
    private AddGroupMemberResultMsg addGroupMemberResultMsg = new AddGroupMemberResultMsg();
}
