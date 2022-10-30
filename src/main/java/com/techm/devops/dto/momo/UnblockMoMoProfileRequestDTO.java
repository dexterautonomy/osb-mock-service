package com.techm.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("unblockaccountrequest")
public class UnblockMoMoProfileRequestDTO {
    @JsonProperty("fri")
    public String fri;
    @JsonProperty("reason")
    public String reason;
}
