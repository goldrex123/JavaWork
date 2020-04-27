package com.lec.java.crawl03;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException {
		System.out.println("다음 인기 검색어");
		
		String url;
		Response response;
		Document doc;
		Elements elements;
		Element element;
		
		url = "https://www.daum.net";
		response = Jsoup.connect(url).execute();
		
		doc = response.parse();
		
		elements = doc.select("ul.list_favorsch a");
		
		for(Element e : elements){
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		
		System.out.println("\n 프로그램 종료");
	}

}
