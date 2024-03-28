import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DaumNewsTodaySeries {

    public static void main(String args[]) {
        System.out.println("다음 뉴스의 오늘의 연재 출력하기");
        System.out.println();

        // 문제 1) jsoup을 사용하여 다음 뉴스의 오늘의 연재 부분을 파싱하여
        // 화면에 출력하는 프로그램의 작성하세요.
        // 출력 형태 : 기사 제목, 기사 링크 2가지 내용을 출력하세요.



        String url = "https://news.daum.net/?nil_profile=mini&nil_src=news";

        Document html = null;

        try {
            Connection.Response response = Jsoup.connect(url).method(Connection.Method.GET).execute();
            html = response.parse();
        } catch (IOException e) {
            System.out.println("데이터 파싱 중 오류 발생");
            e.printStackTrace();
        }

        Element list_todayseries = html.select(".list_todayseries").first();

        Elements link_txt = list_todayseries.select(".link_txt");

        for (int i = 0; i < link_txt.size(); i++) {
            Element item = link_txt.get(i);
            Element todaysSeriesTag = item.select(".link_txt").first();
            String todaysSeriesTitle = todaysSeriesTag.text();
            String todaysSeriesLink = todaysSeriesTag.attr("href");
            System.out.println("NEWS Title : " + todaysSeriesTitle);
            System.out.println("NEWS Link : " + todaysSeriesLink);

        // 240328 기사 가져오기
        // 1. 기사 페이지 url 설정
        // 2. 기사 페이지의 html태그를 받을 document 객체 생성
        // 3. Jsoup.connect()를 사용하여 기사 페이지에 접속
        // 4. parse()를 사용하여 가져온 html 태그를  document객체에 저장
        // 5. 기사 내용이 있는 태그를 select()를 사용하여 검색
        // 6. 기사 내용 가져오기

            System.out.println("=================================================");

        }
    }
}
