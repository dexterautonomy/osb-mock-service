package com.techm.devops.dto.ss.ocs.cugsubscription.removecug;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("DelGroupMemberResultMsg")
    private DelGroupMemberResultMsg delGroupMemberResultMsg = new DelGroupMemberResultMsg();
}
