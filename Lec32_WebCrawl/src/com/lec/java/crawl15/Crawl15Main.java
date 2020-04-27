package com.lec.java.crawl15;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/*XML, JSON 파싱 연습
 * 
 * ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울
 */

public class Crawl15Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jackson-databin 연습2");

		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL(
				"http://swopenapi.seoul.go.kr/api/subway/7655456c64676f6c32394879425774/json/stationInfo/1/5/%EC%84%9C%EC%9A%B8");

		StList stList = mapper.readValue(url, StList.class);
		int i = 1;
		

		for (StationList e : stList.getStationList()) {
			System.out.printf("%d: %s역 %s %s\n", i, e.getStatnNm(), e.getSubwayId(), e.getSubwayNm());
			i++;
		}

		System.out.println("\n프로그램 종료");
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class StList {
	
	private List<StationList> stationList;

	public StList() {
		super();
	}

	public StList(List<StationList> stationList) {
		super();
		this.stationList = stationList;
	}

	public List<StationList> getStationList() {
		return stationList;
	}

	public void setStationList(List<StationList> stationList) {
		this.stationList = stationList;
	}
	
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class StationList {
	private String statnNm;
	private String subwayId;
	private String subwayNm;

	public StationList() {
		super();
	}

	public StationList(String statnNm, String subwayId, String subwayNm) {
		super();
		this.statnNm = statnNm;
		this.subwayId = subwayId;
		this.subwayNm = subwayNm;
	}

	public String getStatnNm() {
		return statnNm;
	}

	public void setStatnNm(String statnNm) {
		this.statnNm = statnNm;
	}

	public String getSubwayId() {
		return subwayId;
	}

	public void setSubwayId(String subwayId) {
		this.subwayId = subwayId;
	}

	public String getSubwayNm() {
		return subwayNm;
	}

	public void setSubwayNm(String subwayNm) {
		this.subwayNm = subwayNm;
	}
	
	@Override
		public String toString() {
			return statnNm + " " + subwayId + " " + subwayNm;
		}
}
