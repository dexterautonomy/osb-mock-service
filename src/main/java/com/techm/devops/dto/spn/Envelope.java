package com.techm.devops.dto.spn;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Envelope {
    @JsonProperty("Body")
    public Body body = new Body();
}
