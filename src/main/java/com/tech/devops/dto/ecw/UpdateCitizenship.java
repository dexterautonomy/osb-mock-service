package com.tech.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("updateaccountholdercitizenshiprequest")
public class UpdateCitizenship {
	private String identity;
    private Citizenships citizenships;
    private String reason;
}