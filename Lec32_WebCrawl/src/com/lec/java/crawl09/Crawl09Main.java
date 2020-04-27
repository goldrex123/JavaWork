package com.lec.java.crawl09;

import java.io.IOException;
import java.net.URLEncoder;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//연습
//네이버 '검색어'
//블로그
// -post title
// -post url
// -blog title

//페이징 구현
public class Crawl09Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 검색, 페이징");

		for (int i = 1; i <= 100; i += 10) {
			crawlNaverBlog("파이썬", i);
		}

		System.out.println("\n프로그램 종료");
	}

	public static void crawlNaverBlog(String search, int postNum) throws IOException {
		// 목록에서 크롤링
		// post title
		// post link url
		// blog title

		if (search == null || search.trim().length() == 0 || postNum < 1)
			return; // 매개변수 검증

		String url;
		Document doc;
		Response response;
		Elements elements;
		Elements rowElements;

		url = String.format(
				"https://search.naver.com/search.naver?date_from=&date_option=0&date_to=&dup_remove=1&nso=&post_blogurl=&post_blogurl_without="
				+ "&query=%s&sm=tab_pge&srchby=all&st=sim&where=post&start=%d",
				URLEncoder.encode(search, "utf-8"), postNum);

		doc = Jsoup.connect(url).execute().parse();

		elements = doc.select("ul#elThumbnailResultArea li");

		for (Element e : elements) {
			String postTitle = e.selectFirst("dt a").text().trim();
			String linkUrl = e.selectFirst("dt a").attr("href").trim();
			String blogTitle = e.selectFirst("dd.txt_block > span > a").text().trim();

			System.out.println(postTitle + " : " + linkUrl + " : " + blogTitle);
		}
		System.out.println();
		
	}
}
