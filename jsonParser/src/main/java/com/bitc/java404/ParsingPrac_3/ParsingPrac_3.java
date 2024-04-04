package com.bitc.java404.ParsingPrac_3;

import com.bitc.java404.ParsingPrac_2.DTO.TagoDTO;
import com.bitc.java404.ParsingPrac_2.DTO.TagoItemDTO;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ParsingPrac_3 {
    public void tagoParserUrl(String serviceUrl) throws Exception{
        // 열차 정보를 저장할 list
        List<TagoItemDTO> itemList = null;

        // 열차 정보를 제공하는 서비스의 url 정보를 입력하기 위한 자바에서 제공하는 URL 객체
        URL url = null;
        // 지정한 URL을 기반으로 http 프로토콜로 접속하여 데이터를 가져오는 클래스
        HttpURLConnection urlConn = null;
        // HttpURLConnection을 통해서 서비스에 접근하여 가져온 데이터를 빠르게
        BufferedReader reader = null;

        try {
            // 매개변수로 받아온 서비스 주소를 URL 클래스 타입의 객체로 생성
            url = new URL(serviceUrl);
            // openConnection()을 사용하여 지정한 url로 접속
            // 접속 정보를 HttpURLConnection 타입의 객체에 넘김
            urlConn = (HttpURLConnection) url.openConnection();
            // 접속 방식을 GET 타입으로 설정
            urlConn.setRequestMethod("GET");

            // getInputStream()을 사용하여 접속한 서비스에서 데이터를 가져옴
            // BufferedReader를 사용하여 서비스를 제공하는 곳에서 데이터를 가져와서 버퍼에 저장 후 한번에 가져옴
            reader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null){
                sb.append(line);
            }

            Gson gson = new Gson();
            TagoDTO tago = gson.fromJson(sb.toString(), TagoDTO.class);
            itemList = tago.getResponse().getBody().getItems().getItem();

        } catch (Exception e){

            e.printStackTrace();

        } finally {
            if (reader != null) {reader.close();}
            if (urlConn != null) {urlConn.disconnect();}
        }

        for (TagoItemDTO item : itemList) {
            System.out.println("열차번호 : " + item.getTrainno());
            System.out.println("열차종류 : " + item.getTraingradename());
            System.out.println("출발지 : " + item.getDepplacename());
            System.out.println("출발시간 : " + item.getDepplandtime());
            System.out.println("도착지 : " + item.getArrplacename());
            System.out.println("도착시간 : " + item.getArrplandtime());
            System.out.println("열차운임 : " + item.getAdultcharge());
            System.out.println("============================================");
        }
    }
}
