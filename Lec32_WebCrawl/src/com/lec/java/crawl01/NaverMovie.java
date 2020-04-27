package com.lec.java.crawl01;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NaverMovie {

	public static void main(String[] args) throws IOException {

		String url;
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#assistant > div:nth-child(1) li");
		
		for(Element e : elements) {
			e.selectFirst("span.blind").remove(); //1위, 2위... 텍스트 <span> 없애려면 해당 element 삭제 (remove())
			System.out.println(e.selectFirst("a").text().trim());
		}
	}

}
