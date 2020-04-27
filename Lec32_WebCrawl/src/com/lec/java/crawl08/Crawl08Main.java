package com.lec.java.crawl08;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* 크롤링 검색 페이징
 *   - '첫 페이지' url 
 *   - '두 번째 페이지'부터의 url 변화 확인 : 어떤 방식? 어떤 parameter 사용?
 * 	 - 검색 결과 페이징의 '마지막 페이지'는 어떻게 처리하는지 확인 
 */
public class Crawl08Main {

	public static void main(String[] args) throws IOException {
		System.out.println("페이징 : Pagiantion");

		for (int i = 1; i <= 10; i++) {
			crawlDaumBlog("파이썬", i);
		}

		System.out.println("\n프로그램 종료");
	}

	/**
	 * 
	 * @param search 검색어
	 * @param page   검색할 결과 page 번호
	 * @throws Exceptioneption
	 */
	public static void crawlDaumBlog(String search, int page) throws IOException {
		// 목록에서 크롤링
		// post title
		// post link url
		// blog title

		if (search == null || search.trim().length() == 0 || page < 1)
			return; // 매개변수 검증

		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;

		System.out.println(page + " 페이지");
		url = String.format("https://search.daum.net/search?w=blog&DA=PGD&enc=utf8&q=%s&page=%d",
				URLEncoder.encode(search, "utf-8"), page);
//		System.out.println(url); //확인용 

		doc = Jsoup.connect(url).execute().parse();

		elements = doc.select("#blogColl .list_info li .wrap_cont");
//		System.out.println(elements.size()); //확인용

		for (Element e : elements) {
			String postTitle = e.selectFirst("a").text().trim();
			String blogTitle = e.selectFirst(".info .f_nb").text().trim();
			String postUrl = e.selectFirst("a").attr("href").trim();

			System.out.println(postTitle + " : " + blogTitle + " : " + postUrl);
		}

		System.out.println();

	} // end crawlDaumBlog
}