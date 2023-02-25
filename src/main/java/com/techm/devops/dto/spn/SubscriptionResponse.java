package com.techm.devops.dto.spn;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubscriptionResponse {
    @JsonProperty("Body")
    public Body body;
}