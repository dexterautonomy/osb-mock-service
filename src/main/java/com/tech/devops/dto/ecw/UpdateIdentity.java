package com.tech.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("updateaccountholderidentificationrequest")
public class UpdateIdentity {
	private String identity;
    private Identifications identifications;
    private String reason;
}