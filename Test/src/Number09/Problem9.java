package Number09;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Problem9 {

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
			System.out.println(e.selectFirst("a").text().trim());
		}
	}
}
