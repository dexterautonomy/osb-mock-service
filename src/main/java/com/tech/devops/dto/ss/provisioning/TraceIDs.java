package com.tech.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TraceIDs {

    @JsonProperty("TraceID")
    public int traceID = 1;

}