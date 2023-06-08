package com.tech.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@JsonRootName("getaccountholderinforequest")
public class AccountHolderInfo {
	private String identity;
}