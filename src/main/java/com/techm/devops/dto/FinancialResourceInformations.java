package com.techm.devops.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FinancialResourceInformations {
	@JsonProperty("defaultfri")
	private FinancialResource financialResource;
}
