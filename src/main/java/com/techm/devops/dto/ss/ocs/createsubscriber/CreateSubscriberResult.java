package com.techm.devops.dto.ss.ocs.createsubscriber;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateSubscriberResult {

    @JsonProperty("EffectiveTime")
    public String effectiveTime = "123456781234567823456";

}