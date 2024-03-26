import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JavaTest {
    public static void main(String args[]) {
        System.out.println("Hello World");


//        System.out.println("======= 구글 홈페이지 가져오기(Document 방식) =======");
//        try {
//            Document google = Jsoup.connect("https://www.google.co.kr/").get();
//            System.out.println(google);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


//        System.out.println("======= 구글 홈페이지 가져오기(Connection 방식) =======");
//        try {
//            Connection.Response res = Jsoup.connect("https://www.google.co.kr/").method(Connection.Method.GET).execute();
//            Document google2 = res.parse();
//            System.out.println(google2);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        Document document = null;
        Connection.Response res = null;

        try {
            res = Jsoup.connect("https://www.google.co.kr/").method
                    (Connection.Method.GET).execute();
            document = res.parse();
        } catch (IOException e) {
            System.out.println("Jsoup로 html 파싱 중 오류가 발생했습니다.");
            e.printStackTrace();
        }

//        System.out.println("======= html() 출력 =======");
//        System.out.println(document.html());
//
//        System.out.println("======= text() 출력 =======");
//        System.out.println(document.text());

        // select 사용하기
//        Element btnK = document.select("input[name=btnK]").first();
//        String btnKValue = btnK.attr("value");
//        System.out.println("select로 출력 : " + btnKValue);
//
//
//        Elements btns = document.select("input[name=btnK]");
//        for (int i = 0; i < btns.size(); i++) {
//            Element btn = btns.get(i);
//            String btnValue = btn.attr("value");
//            System.out.println("select로 출력 : " + i + " : " + btnValue);
//        }

        // select()를 이용하여 html 태그명을 검색
//        Elements imgs = document.select("img");
//        System.out.println("img 태그의 수 : " + imgs.size());
//        for (int i = 0; i < imgs.size(); i++) {
//            Element img = imgs.get(i);
//            String imgSrc = img.attr("src");
//            if (imgSrc.isEmpty()) {
//                continue;
//            }
//            System.out.println((i+1) + "번째 img 태그 : " + imgSrc);
//        }

        // id명으로 서치
/*
        Elements inputs = document.select("#APjFqb");
        System.out.println("사용자 입력란 수 : " + inputs.size());
*/

        // first()를 사용하여 검색된 태그 중 첫번째 #APjFqb
/*        Element input = document.select("#APjFqb"). first();
        String inputValue = input.attr("title");
        System.out.println("사용자 입력란 title : " + inputValue);*/

        // select()를 사용하여 class 값 검색
/*
        Elements classes = document.select(".o3j99");
        System.out.println("o3j99 개수" + classes.size());
*/

/*        for (int i = 0; i < classes.size(); i++){
            Element item = classes.get(i);
            Element style = item.select("style").first();
            System.out.println(style);
        }*/


        System.out.println();

        // select()를 사용하여 지정한 태그(".LX3sZb")를 제외한 나머지 태그 가져오기
        Elements elements = document.select(".o3j99");
        System.out.println("class.o3j99 : " + elements.size());

        Elements divList1 = elements.select("div");
        Elements divList2 = elements.select("div").not(".LX3sZb");

        System.out.println("divList1 : " + divList1.size() + "개");
        System.out.println("divList2 : " + divList2.size() + "개");

        System.out.println();

        // select()를 사용하여 지정한 태그(".o3j99")를 제외한 나머지 태그 가져오기
        // 전체 html 문서에서 클래스 값이 L3eUgb인 태그 중 가장 먼저 검색되는 태그 1개를 가져옴
        Element element = document.select(".L3eUgb").first();
        // 클래스 값이 L3eUgb의 자식 태그 중 "div" 태그를 모두 가져옴
        divList1 = element.select("div");
        // "div" 태그 중 클래스명이 ".o3j99"인 클래스는 제외 후 가져옴
        divList2 = element.select("div").not(".o3j99");

        System.out.println(".o3j99 포함 : " + divList1.size() + "개");
        System.out.println(".o3j99 포함 : " + divList2.size() + "개");


System.out.println();


        // getElementById()를 사용하여 태그 1개 검색
//        Element divTag =


        // getElementByTag()를 사용하여 지정한 태그를 모두 검색
        Elements divList = document.getElementsByTag("div");
        System.out.println("divList 수 : " + divList.size() + "개");

        // getElementByClass를 사용하여 지정한 class값을 가지고 있는 모든 태그를 검색
        divList = document.getElementsByClass("o3j99");
        System.out.println("o3j99 수 : " + divList.size() + "개");


        System.out.println();


        // Element 객체에서 제공하는 메소드 사용하기
        Element imgTag = document.select("img").first();
        String attrValue = imgTag.attr("src");
        System.out.println("img의 src 값 가져오기 : " + attrValue);
        attrValue = imgTag.attr("alt");
        System.out.println("img의 alt 값 가져오기 : " + attrValue);

        // attr()로 값 설정하기
        imgTag.attr("alt", "구글");
        attrValue = imgTag.attr("alt");
        System.out.println("attr()로 속성값 변경 후 : " + attrValue);


        System.out.println();


        // id()로 id 속성 값 가져오기
        String idValue = imgTag.id();
        System.out.println("id 속성값 : " + idValue);

        // className()으로 class 속성 값 가져오기
        String classValue = imgTag.className();
        System.out.println("class 속성값 : " + classValue);



        // text()로 문자열 출력
        Elements divj99List = document.select(".o3j99");
        for (int i = 0; i < divj99List.size(); i++) {
            Element item = divj99List.get(i);
            Elements subitemList = item.select(".MV3Tnb");

            for (int j = 0; j < subitemList.size(); j++) {
                Element tag = subitemList.get(j);
                System.out.println(tag);
                System.out.println(tag.text());
                System.out.println("=======================================");
            }
        }



    }

    }

