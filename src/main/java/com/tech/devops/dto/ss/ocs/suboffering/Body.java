package com.tech.devops.dto.ss.ocs.suboffering;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("ChangeSubOfferingResultMsg")
    private ChangeSubOfferingResultMsg changeSubOfferingResultMsg = new ChangeSubOfferingResultMsg();
}
