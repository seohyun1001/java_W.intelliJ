package com.bitc.java404;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class GsonTest {

    // Gson 객체 생성하기
    public void createGson() {
        Gson gson1 = new Gson(); // 일반 Gson 객체 생성
        Gson gson2 = new GsonBuilder().create();// 빌더 타입으로 객체 생성하기
    }



    // Json 생성하기
    public void createJson() {
        Gson gson = new Gson();

        JsonObject jobj = new JsonObject();
        jobj.addProperty("name", "박병찬");
        jobj.addProperty("gender", "남성");
        jobj.addProperty("job", "농구선수");

        String jsonStr = gson.toJson(jobj);

        System.out.println(jsonStr);
    }

    // Java Object를 Json으로 변환

    // Json을 Java Object로 변환

    // Map 타입을 Json으로 변환

    // Json을 Map 타입으로 변환



}
