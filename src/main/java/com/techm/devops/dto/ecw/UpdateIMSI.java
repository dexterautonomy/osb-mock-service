package com.techm.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("setimsirequest")
public class UpdateIMSI {
	private String identity;
    private String imsi;
    private String reason;
}