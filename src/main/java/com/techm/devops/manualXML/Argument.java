package com.techm.devops.manualXML;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Argument {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private String value;

    @Override
    public String toString() {
        StringBuilder xml = new StringBuilder();
        xml.append("<arguments");
        xml.append(" name=\"").append(name).append("\"");
        xml.append(" value=\"").append(value).append("\"");
        xml.append("/>");
        return xml.toString();
    }
}