package com.imooc.recyclerview.utils;

import com.google.gson.Gson;
import com.google.gson.JsonNull;

import java.lang.reflect.Type;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;




public class JsonUtil {
    private static Gson gson=new Gson();
    private JsonUtil(){}
    public static String toJson(Object src){
        if(src==null){
            return gson.toJson(JsonNull.INSTANCE);
        }
        return gson.toJson(src);
    }

    public static <T>Object fromJson(String json, Class<T>classOfT){
        return gson.fromJson(json,(Type)classOfT);
    }

}
