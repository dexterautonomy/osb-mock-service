package com.tech.devops.manualXML;

import lombok.Data;

@Data
public class Argument {
    private String name;
    private String value;

    @Override
    public String toString() {
        StringBuilder xml = new StringBuilder();
        xml.append("<arguments");
        xml.append(" name=\"")
                .append(name).append("\"");
        xml.append(" value=\"")
                .append(value).append("\"");
        xml.append("/>");
        return xml.toString();
    }
}