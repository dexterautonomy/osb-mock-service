package com.tech.devops.manualXML;

public class Fault {
    public static String fault() {
        StringBuilder xml = new StringBuilder();
        xml.append("<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
        xml.append("<soap:Body>");
        xml.append("<soap:Fault>");
        xml.append("<faultcode>soap:Client</faultcode>");
        xml.append("<faultstring>The requested operation was rejected. Please consult with your administrator.Your support ID is: 15025064115704129377</faultstring>");
        xml.append("<detail/>");
        xml.append("</soap:Fault>");
        xml.append("</soap:Body>");
        xml.append("</soap:Envelope>");

        return xml.toString();
    }
}
