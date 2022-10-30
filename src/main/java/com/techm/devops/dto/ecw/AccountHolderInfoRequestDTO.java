package com.techm.devops.dto.ecw;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccountHolderInfoRequestDTO {
    @JsonProperty("identity")
    public String identity;
}