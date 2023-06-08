package com.tech.devops.manualXML;

import lombok.Data;

@Data
public class Body {
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