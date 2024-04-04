package com.bitc.java404.ParsingPrac_2;

import com.google.gson.Gson;

public class ParsingPrac_2 {
    public void tagoParser() {
        String jsonData = "{\"response\":{\"header\":{\"resultCode\":\"00\",\"resultMsg\":\"NORMAL SERVICE.\"},\"body\":{\"items\":{\"item\":[{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406061200,\"depplacename\":\"서울\",\"depplandtime\":20240406051200,\"traingradename\":\"KTX\",\"trainno\":1},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406063200,\"depplacename\":\"서울\",\"depplandtime\":20240406052700,\"traingradename\":\"KTX\",\"trainno\":3},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406070200,\"depplacename\":\"서울\",\"depplandtime\":20240406055700,\"traingradename\":\"KTX\",\"trainno\":5},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406073800,\"depplacename\":\"서울\",\"depplandtime\":20240406063200,\"traingradename\":\"KTX\",\"trainno\":7},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406074800,\"depplacename\":\"서울\",\"depplandtime\":20240406064200,\"traingradename\":\"KTX\",\"trainno\":233},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406080700,\"depplacename\":\"서울\",\"depplandtime\":20240406065600,\"traingradename\":\"KTX\",\"trainno\":9},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406083200,\"depplacename\":\"서울\",\"depplandtime\":20240406072700,\"traingradename\":\"KTX\",\"trainno\":11},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406084700,\"depplacename\":\"서울\",\"depplandtime\":20240406074900,\"traingradename\":\"KTX\",\"trainno\":13},{\"adultcharge\":23700,\"arrplacename\":\"대전\",\"arrplandtime\":20240406090200,\"depplacename\":\"서울\",\"depplandtime\":20240406075700,\"traingradename\":\"KTX\",\"trainno\":15},{\"adultcharge\":17200,\"arrplacename\":\"대전\",\"arrplandtime\":20240406095500,\"depplacename\":\"서울\",\"depplandtime\":20240406081100,\"traingradename\":\"KTX\",\"trainno\":121}]},\"numOfRows\":10,\"pageNo\":1,\"totalCount\":66}}}";

        System.out.println("========= TAGO 열차 정보 출력하기 =========");

        Gson gson = new Gson();



    }
}
