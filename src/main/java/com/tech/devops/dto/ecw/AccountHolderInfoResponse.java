package com.tech.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonRootName(value = "getaccountholderinforesponse")
public class AccountHolderInfoResponse {
	@JsonProperty("accountholderbasicinfo")
	AccountHolderBasicInfo accountHolderBasicInfo;
}