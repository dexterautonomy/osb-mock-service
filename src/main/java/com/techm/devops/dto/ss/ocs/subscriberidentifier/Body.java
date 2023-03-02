package com.techm.devops.dto.ss.ocs.subscriberidentifier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {

    @JsonProperty("ChangeSubIdentityResultMsg")
    private  ChangeSubIdentityResultMsg changeSubIdentityResultMsg = new ChangeSubIdentityResultMsg();
}
