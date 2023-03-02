package com.techm.devops.dto.ss.ocs.primaryoffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("ChangeSubOfferingResultMsg")
    private ChangeSubOfferingResultMsg changeSubOfferingResultMsg = new ChangeSubOfferingResultMsg();
}
