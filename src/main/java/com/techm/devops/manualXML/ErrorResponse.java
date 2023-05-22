package com.techm.devops.manualXML;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {
    private String errorCode = "VALIDATION_ERROR";
    private List<Argument> arguments = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder xml = new StringBuilder();
        xml.append("<errorResponse");
        xml.append(" errorcode=\"")
                .append(errorCode)
                .append("\"");
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