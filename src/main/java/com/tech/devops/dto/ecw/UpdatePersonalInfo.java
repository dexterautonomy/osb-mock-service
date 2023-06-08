package com.tech.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("updateaccountholderpersonalinformationrequest")
public class UpdatePersonalInfo {
	private String identity;
    private Information information;
    private String reason;
}