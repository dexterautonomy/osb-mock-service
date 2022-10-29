package com.techm.devops.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
//@JsonRootName("EDARequest")
@JsonRootName("caiRequest")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EDARequest {
//	@JsonProperty("LoginCredentialRequest")
//	private String loginCredentialRequest;
//	@JsonProperty("CAITextRequest")
//	private String caiTextRequest;

	@JsonProperty("login")
	private String loginCredentialRequest;
	@JsonProperty("request")
	private String caiTextRequest;
}
