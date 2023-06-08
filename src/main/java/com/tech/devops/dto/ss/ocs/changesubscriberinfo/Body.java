package com.tech.devops.dto.ss.ocs.changesubscriberinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("ChangeSubInfoResultMsg")
    private ChangeSubInfoResultMsg changeSubInfoResultMsg = new ChangeSubInfoResultMsg();
}
