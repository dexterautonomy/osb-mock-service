package com.tech.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FinancialResource {
	@JsonProperty("fri")
    private String financialResourceInfo;
	@JsonProperty("currency")
    private Currency currency;
}