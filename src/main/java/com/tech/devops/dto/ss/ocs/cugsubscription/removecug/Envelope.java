package com.tech.devops.dto.ss.ocs.cugsubscription.removecug;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Envelope {
    @JsonProperty("Body")
    private Body body = new Body();
}
