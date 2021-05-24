package com.ssafy.happyHouse.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Crawler {
    @Scheduled(cron = "0 0 12 * * *")
//	@Scheduled(fixedDelay = 5000)
	public void cronJobSch() {
		String URL = "https://www.google.com/search?q=%EC%95%84%ED%8C%8C%ED%8A%B8&tbm=nws";

		try {
			// 2. Connection 생성
			Connection conn = Jsoup.connect(URL);

			// 3. HTML 파싱.
			Document html = conn.get(); // conn.post();

			// 4. 요소 탐색
			Elements names = html.getElementsByClass("JheGif nDgy9d");
			ArrayList<String> nameList = new ArrayList<>();
			for(Element name : names) {
				nameList.add(name.text());
			}
			
			Elements dbsr = html.getElementsByClass("dbsr");
			ArrayList<String> hrefList = new ArrayList<>();
			for(Element text : dbsr) {
				Elements files = text.getElementsByTag("a");
				String href = files.attr("href");
				hrefList.add(href);
			}
			JSONObject data = new JSONObject();
	        JSONArray req_array = new JSONArray();
			for(int i=0; i<(nameList.size() < 6 ? nameList.size() : 6); i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("newsName", nameList.get(i));
				jsonObject.put("newsHref", hrefList.get(i));
				req_array.add(jsonObject);
			}
			data.put("newsList", req_array);
	        String jsonInfo = data.toJSONString();
	    	try {
	    		FileWriter file = new FileWriter("src/main/resources/newsJson.json");
	    		file.write(data.toJSONString());
	    		file.flush();
	    		file.close();
	     
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
