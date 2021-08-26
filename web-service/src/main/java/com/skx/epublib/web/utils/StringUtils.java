package com.skx.epublib.web.utils;

import org.json.JSONObject;

import java.util.Map;
import java.util.UUID;

public class StringUtils {
    public static String sayHello(){
        return "Hello!";
    }

    public static Map<String,Object> parseJSON(String json){
        return new JSONObject(json).toMap();
    }
    // 生成随机字符串
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
