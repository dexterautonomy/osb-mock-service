package com.techm.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Identification {
	@JsonProperty("Id")
	private String id;
	@JsonProperty("IdTp")
    private String idTp;
}