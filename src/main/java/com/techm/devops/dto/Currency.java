package com.techm.devops.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Currency {
    private String code;
}