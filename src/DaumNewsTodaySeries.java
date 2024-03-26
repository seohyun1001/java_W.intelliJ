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
            System.out.println("=================================================");

        }
    }
}
