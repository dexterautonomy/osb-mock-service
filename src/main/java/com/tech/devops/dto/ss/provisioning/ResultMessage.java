package com.tech.devops.dto.ss.provisioning;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultMessage {

    @JsonProperty("MessageHeader")
    public MessageHeader messageHeader = new MessageHeader();
    @JsonProperty("MessageBody")
    public MessageBody messageBody = new MessageBody();

}