package com.techm.devops.dto.ss.ocs.createsubscriber;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techm.devops.dto.ss.ocs.subdeactivation.ResultHeader;
import lombok.Data;

@Data
public class CreateSubscriberResultMsg {

    @JsonProperty("ResultHeader")
    public ResultHeader resultHeader;
    @JsonProperty("CreateSubscriberResult")
    public CreateSubscriberResult createSubscriberResult = new CreateSubscriberResult();

}