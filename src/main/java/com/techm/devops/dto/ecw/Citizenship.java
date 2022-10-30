package com.techm.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Citizenship {
	@JsonProperty("Ntlty")
	private String Ntlty;
	@JsonProperty("MnrInd")
    private String MnrInd;
}