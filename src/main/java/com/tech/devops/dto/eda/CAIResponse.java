package com.tech.devops.dto.eda;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
//@JsonRootName("EDAResponse")
@JsonRootName("caiResponse")
public class CAIResponse {
//	@JsonProperty("ExtraResponse")
	@JsonProperty("response1")
	private String extraResponse;
//	@JsonProperty("ActualResponse")
	@JsonProperty("response2")
	private String actualResponse;
}
