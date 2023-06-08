package com.tech.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Occupation {
	private String profession;
	@JsonProperty("employingcompany")
    private String employingCompany;
}