package com.techm.devops.dto.ss.ocs.subdeactivation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("SubDeactivationResultMsg")
    private SubDeactivationResultMsg subDeactivationResultMsg = new  SubDeactivationResultMsg();
}
