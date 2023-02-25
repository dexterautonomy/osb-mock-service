package com.techm.devops.dto.ss.ocs.envelope.addcug;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Envelope {
    @JsonProperty("Body")
    public Body body = new Body();
}