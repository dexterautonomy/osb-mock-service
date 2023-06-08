package com.tech.devops.dto.ss.ocs.changesubstatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChangeSubStatusResult {

    @JsonProperty("OldStatus")
    public String oldStatus = "I was a sinner man";
    @JsonProperty("NewStatus")
    public String newStatus = "Go and sin no more";

}