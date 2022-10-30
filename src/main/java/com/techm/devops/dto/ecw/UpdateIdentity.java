package com.techm.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonRootName;

import com.techm.devops.dto.ecw.Identifications;
import lombok.Data;

@Data
@JsonRootName("updateaccountholderidentificationrequest")
public class UpdateIdentity {
	private String identity;
    private Identifications identifications;
    private String reason;
}