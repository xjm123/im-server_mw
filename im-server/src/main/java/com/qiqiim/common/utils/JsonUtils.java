package com.qiqiim.common.utils;


import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

    public static String ObjToJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    public static <T> T jsonToObj(String json,Class<T> classOfT){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(json, classOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
