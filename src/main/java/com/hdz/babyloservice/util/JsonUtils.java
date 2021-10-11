package com.hdz.babyloservice.util;



import com.google.gson.Gson;
import com.hdz.babyloservice.bean.BaseJson;

public class JsonUtils {
	
	public static <T> String createBaseJson(int code,T t,String msg){
		BaseJson<T> baseJson = new BaseJson<T>();
		baseJson.setCode(code);
		baseJson.setData(t);
		baseJson.setMsg(msg);
		Gson gson = new Gson();
		return gson.toJson(baseJson, BaseJson.class);
	}
}
