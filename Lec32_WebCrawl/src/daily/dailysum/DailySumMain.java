package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/7655456c64676f6c32394879425774/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/7655456c64676f6c32394879425774/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요


public class DailySumMain {

	public static final String API_KEY = "7655456c64676f6c32394879425774";
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String date;
		int startIndex;
		int endIndex;
	
		System.out.print("날짜입력: ");
		date = sc.nextLine();
		System.out.print("시작Index: ");
		startIndex = sc.nextInt();
		System.out.print("끝Index: ");
		endIndex = sc.nextInt();
		
		System.out.println("[XML]");
		System.out.println("날짜\t\t구ID\t총생활인구수\t일최대이동인구수");
		String url = buildUrlAddress("xml", startIndex, endIndex, date);
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get();
		
		Elements elements = doc.select("row");
		
		for(Element e : elements) {
			System.out.print(e.selectFirst("STDR_DE_ID").text().trim() + "\t");
			System.out.print(e.selectFirst("SIGNGU_CODE_SE").text().trim()+ "\t");
			System.out.print(e.selectFirst("TOT_LVPOP_CO").text().trim()+ "\t");
			System.out.println(e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim()+ "\t");
		}
		
		System.out.println();
		
		URL url2 = new URL(buildUrlAddress("json", startIndex, endIndex, date));
		System.out.println("[JSON]");
		System.out.println("날짜\t구ID\t총생활인구수\t일최대이동인구수");
		ObjectMapper mapper = new ObjectMapper();
		

		Homework hw = mapper.readValue(url2, Homework.class);
		
		for(Pf p : hw.getSPOP_DAILYSUM_JACHI().getRow()) {
			System.out.print(p.getStrId() + "\t");
			System.out.print(p.getSinSe() + "\t");
			System.out.print(p.getTotCo() + "\t");
			System.out.println(p.getDailCo() + "\t");
		}

		sc.close();
	} // end main

	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String date) {

		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/SPOP_DAILYSUM_JACHI/%d/%d/%s", API_KEY,
				reqType, startIndex, endIndex, date);

		return url_address;
	}
} // end class


@JsonIgnoreProperties(ignoreUnknown = true)
class Homework{
	public Stat SPOP_DAILYSUM_JACHI;

	public Homework(Stat sPOP_DAILYSUM_JACHI) {
		super();
		SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
	}

	public Homework() {
		super();
	}

	public Stat getSPOP_DAILYSUM_JACHI() {
		return SPOP_DAILYSUM_JACHI;
	}

	public void setSPOP_DAILYSUM_JACHI(Stat sPOP_DAILYSUM_JACHI) {
		SPOP_DAILYSUM_JACHI = sPOP_DAILYSUM_JACHI;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Stat{
	private List<Pf> row;

	public Stat() {
		super();
	}

	public Stat(List<Pf> row) {
		super();
		this.row = row;
	}

	public List<Pf> getRow() {
		return row;
	}

	public void setRow(List<Pf> row) {
		this.row = row;
	}
	
	
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Pf{
	@JsonProperty("STDR_DE_ID")
	private String strId;
	
	@JsonProperty("SIGNGU_CODE_SE")
	private String sinSe;
	
	@JsonProperty("TOT_LVPOP_CO")
	private String totCo;
	
	@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
	private String dailCo;

	public Pf() {
	}

	public Pf(String strId, String sinSe, String totCo, String dailCo) {
		this.strId = strId;
		this.sinSe = sinSe;
		this.totCo = totCo;
		this.dailCo = dailCo;
	}

	public String getStrId() {
		return strId;
	}

	public void setStrId(String strId) {
		this.strId = strId;
	}

	public String getSinSe() {
		return sinSe;
	}

	public void setSinSe(String sinSe) {
		this.sinSe = sinSe;
	}

	public String getTotCo() {
		return totCo;
	}

	public void setTotCo(String totCo) {
		this.totCo = totCo;
	}

	public String getDailCo() {
		return dailCo;
	}

	public void setDailCo(String dailCo) {
		this.dailCo = dailCo;
	}
	
	
}
