package com.techm.devops.dto.ss.ocs.createsubscriber;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Body {
    @JsonProperty("CreateSubscriberResultMsg")
    private CreateSubscriberResultMsg createSubscriberResultMsg = new CreateSubscriberResultMsg();
}
