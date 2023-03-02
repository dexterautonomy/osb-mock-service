package com.techm.devops.dto.ss.ocs.subscriberidentifier;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Envelope {
    @JsonProperty("Body")
    private Body body = new Body();
}
