package com.tech.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("debitresponse")
public class DebitResponse {
    @JsonProperty("transactionid")
    private String transactionId = "1234567890-098765432";
    @JsonProperty("status")
    private String status = "PENDING";
}
