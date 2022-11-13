package com.techm.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MessageHeader {

    @JsonProperty("DebugFlag")
    public String debugFlag;
    @JsonProperty("SessionID")
    public String sessionID;
    @JsonProperty("TraceIDs")
    public TraceIDs traceIDs;

}