package com.tech.devops.dto.ss.ocs.changesubstatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("ChangeSubStatusResultMsg")
    private ChangeSubStatusResultMsg changeSubStatusResultMsg = new ChangeSubStatusResultMsg();
}
