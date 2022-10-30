package com.techm.devops.dto.momo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("paymentcompletedresponse ")
public class PaymentCompletedResponseDTO {
    @JsonProperty("paymentstatus")
    public String paymentstatus = "COMPLETED";
}
