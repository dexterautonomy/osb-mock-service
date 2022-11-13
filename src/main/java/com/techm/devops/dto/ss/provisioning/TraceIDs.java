package com.techm.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TraceIDs {

    @JsonProperty("TraceID")
    public String traceID = "Trace fire";

}