package com.tech.devops.dto.ecw;

import lombok.Data;

@Data
public class Information {
	private Name name;
    private String gender;
    private String language;
    private Birth birth;
    private Occupation occupation;
}
