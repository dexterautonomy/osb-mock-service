package com.techm.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultMessage {

    @JsonProperty("MessageHeader")
    public MessageHeader messageHeader;
    @JsonProperty("MessageBody")
    public MessageBody messageBody;

}