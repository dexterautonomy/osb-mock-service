package com.techm.devops.manualXML;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "Body")
@XmlAccessorType(XmlAccessType.FIELD)
public class Body {
    @XmlElement(name = "errorResponse")
    private ErrorResponse errorResponse;

    @Override
    public String toString() {
        StringBuilder xml = new StringBuilder();
        xml.append("<Body>");
        xml.append(errorResponse.toString());
        xml.append("</Body>");
        return xml.toString();
    }
}