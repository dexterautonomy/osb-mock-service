package com.techm.devops.manualXML;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponse {
    @XmlAttribute(name = "errorcode")
    private String errorCode = "VALIDATION_ERROR";

    @XmlElement(name = "arguments")
    private List<Argument> arguments = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder xml = new StringBuilder();
        xml.append("<errorResponse");
        xml.append(" errorcode=\"").append(errorCode).append("\"");
        xml.append(">");
        if (arguments != null) {
            for (Argument argument : arguments) {
                xml.append(argument.toString());
            }
        }
        xml.append("</errorResponse>");
        return xml.toString();
    }
}