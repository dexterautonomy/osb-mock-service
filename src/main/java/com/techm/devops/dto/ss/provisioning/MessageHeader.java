package com.techm.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageHeader {
    @JsonProperty("DebugFlag")
    public String debugFlag = "D";
    @JsonProperty("SessionID")
    public String sessionID = "234567890876543";
    @JsonProperty("TraceIDs")
    public TraceIDs traceIDs = new TraceIDs();

}