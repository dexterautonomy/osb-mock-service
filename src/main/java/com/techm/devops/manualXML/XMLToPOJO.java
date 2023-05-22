//package com.techm.devops.manualXML;
//
//import org.w3c.dom.*;
//
//import javax.xml.parsers.*;
//import java.io.*;
//
//public class XMLToPOJO {
//    public static String getBody() {
//        try {
//            File file = new File("C:/Users/chine/Documents/ESF_Production/Java Projects/osb-mock/src/main/resources/file.xml");
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document doc = builder.parse(file);
//
//            Element root = doc.getDocumentElement();
//            ErrorResponse errorResponse = new ErrorResponse();
//            errorResponse.setErrorCode(root.getAttribute("errorcode"));
//
//            NodeList argumentNodes = root.getElementsByTagName("arguments");
//            for (int i = 0; i < argumentNodes.getLength(); i++) {
//                Node argumentNode = argumentNodes.item(i);
//                if (argumentNode.getNodeType() == Node.ELEMENT_NODE) {
//                    Element argumentElement = (Element) argumentNode;
//                    Argument argument = new Argument();
//                    argument.setName(argumentElement.getAttribute("name"));
//                    argument.setValue(argumentElement.getAttribute("value"));
//                    errorResponse.getArguments().add(argument);
//                }
//            }
//
//            Body body = new Body();
//            body.setErrorResponse(errorResponse);
//
//            return body.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//}