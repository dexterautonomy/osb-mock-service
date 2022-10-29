//package com.techm.devops.dto;
//
//import java.lang.reflect.Method;
//
//public class Test {
//    public static void main(String[] args){
//        try {
//            Class clazz = Class.forName(args[0]);
//            Method[] m = clazz.getDeclaredMethods();
//
//            for(Method method : m){
//                System.out.println(method.toString());
//            }
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}