package com.techm.devops.dto.ss.ocs.querycustomerinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SubIdentity {

    @JsonProperty("SubIdentityType")
    public String subIdentityType;
    @JsonProperty("SubIdentity")
    public String subIdentity;
    @JsonProperty("PrimaryFlag")
    public String primaryFlag;

}
