package com.lec.java.crawl16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//  https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.4936151279937&lng=127.032670651995&order=rank&page=0&search=

public class Crawl16Main {

	public static void main(String[] args) throws IOException {
		System.out.println("요기요 맛집정보 : header 추가");
		
		String url = "https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.4936151279937&lng=127.032670651995&order=rank&page=0&search=";
		StringBuffer sb = readFromUrl(url);
//		System.out.println(sb);
		
		ObjectMapper mapper = new ObjectMapper();
		
		Yogi yo = mapper.readValue(sb.toString(),Yogi.class);
		//맛집 이름 , 평점
		
		System.out.println();
//		System.out.println(yo.getRestaurants().size());
		
		for(Rank e : yo.getRestaurants()) {
			System.out.println(e.getName() + "\t\t"+ String.format("%.1f", e.getReview_avg()));
		}
		
		System.out.println("\n프로그램 종료");
	}

	public static StringBuffer readFromUrl(String urlAddress) {

		StringBuffer sb = new StringBuffer(); // response 받은 데이터 담을 객체

		URL url = null; // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnection

		InputStream in = null;
		InputStreamReader reader = null; // byte 스트림 --> 문자기반 Reader
		BufferedReader br = null;

		char[] buf = new char[512]; // 문자용 버퍼

		// BufferedReader <- InputStreamReader <- InputStream <- HttpURLConnection

		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection(); // Connection 객체 생성

			if (conn != null) {
				conn.setConnectTimeout(2000); // 2초이내에 '연결' 이 수립안되면
												// java.net.SocketTimeoutException 발생

				conn.setRequestMethod("GET"); // GET 방식 request -> parameter가 url에 담겨서 request하는것 장점: 북마크 가능 / 단점:
												// parameter가 제한되어있음, 보안성 없음
				// "GET", "POST" ...
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false); // 캐시사용안함

				//헤더 정보 추가
				conn.setRequestProperty("x-ApiKey", "iphoneap");
				conn.setRequestProperty("x-ApiSecret", "fe5183cc3dea12bd0ce299cf110a75a2");
				
				System.out.println("request 시작: " + urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을때까지 delay
				System.out.println("response 완료");

				// response 받은후 가장 먼저 response code 값 확인
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status
				if (responseCode == HttpURLConnection.HTTP_OK) {

					in = conn.getInputStream(); // InputStream <- HttpURLConnection
					reader = new InputStreamReader(in, "utf-8"); // InputStreamReader <- InputStream
					br = new BufferedReader(reader); // BufferedReader <- InputStreamReader

					int cnt; // 읽은 글자의 갯수
					while ((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt); // response 받은 텍스트를 StringBuffer에 추가
					}

				} else {
					System.out.println("response 실패");
					return null;
				}
			} else {
				System.out.println("conn null");
				return null;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (conn != null)
				conn.disconnect(); // 작업 끝나고 connection 해제
		}
		return sb;
	}
}


@JsonIgnoreProperties(ignoreUnknown = true)
class Yogi{
	private List<Rank> restaurants;

	public Yogi(List<Rank> restaurants) {
		super();
		this.restaurants = restaurants;
	}

	public Yogi() {
		super();
	}

	public List<Rank> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Rank> restaurants) {
		this.restaurants = restaurants;
	}
	
}


@JsonIgnoreProperties(ignoreUnknown = true)
class Rank{
	private String name;
	private double review_avg;
	public Rank(String name, double review_avg) {
		super();
		this.name = name;
		this.review_avg = review_avg;
	}
	public Rank() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getReview_avg() {
		return review_avg;
	}
	public void setReview_avg(double review_avg) {
		this.review_avg = review_avg;
	}
	
	
}























