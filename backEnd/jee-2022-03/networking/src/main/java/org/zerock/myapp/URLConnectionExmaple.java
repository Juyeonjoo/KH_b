package org.zerock.myapp;

import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class URLConnectionExmaple {
	
	//URL 객체에서 가장 중요한 기능-> URLConnection 객체를 얻는 것
	//이 URLConnection 객체는 지정된 URL이 http인지 아니면 https인지에 따라
	//실제 타입은 HttpURLConnection 또는 HttpsURLConnection객체를 얻게 됨
	//이번 예제는 이 URlConnection객체로부터 얻을 수 있는 정보를 확인하는 것
	//이 URLConnection 객체를 이용한 공공데이터 포털의 openAPI호출은 이미 배웠음
	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://naver.com");
		HttpsURLConnection urlConn= (HttpsURLConnection) url.openConnection();//***

		log.info("1. urlConn: {} ", urlConn);
		log.info("2. getAllowUserInteraction: {} ", urlConn.getAllowUserInteraction());
		
		log.info("3. getConnectTimeout: {} ", urlConn.getConnectTimeout());
		log.info("16. getReadTimeout: {} ", urlConn.getReadTimeout());
		
		log.info("4. getContent: {} ", urlConn.getContent()); //URL.getContent도 있었는데
		log.info("5. getContentEncoding: {} ", urlConn.getContentEncoding());
		log.info("6. getContentType: {} ", urlConn.getContentType());
		log.info("7. getContentLength: {} ", urlConn.getContentLength());
		
		log.info("8. getDate: {} ", new Date(urlConn.getDate()));
		
		log.info("9. getDefaultUseCaches: {} ", urlConn.getDefaultUseCaches());
		log.info("18. getUseCaches: {} ", urlConn.getUseCaches());
		
		log.info("10. getDoInput: {} ", urlConn.getDoInput());
		log.info("11. getDoOutput: {} ", urlConn.getDoOutput());
		log.info("12. getExpiration: {} ", urlConn.getExpiration());
		log.info("13. getHeaderFields: {} ", urlConn.getHeaderFields());
		
		log.info("14. getIfModifiedSince: {} ", urlConn.getIfModifiedSince());
		log.info("15. getLastModified: {} ", urlConn.getLastModified());

		log.info("17. getURL: {} ", urlConn.getURL());
		
		//위에까지는 아직 Target URL에 접속하지 않은 것
		//아래의 2개 메소드를 통해 실제 연결 생성 => HTTP request(GET방식 전송)=>HTTP response 응답수신
		//=>결국 웹브라우저와 비슷한 HTTP client의 기능을 제공하게 됨(***)
		
		//중요한 점은 위에서 우리가 본 속성들(getter 메소드의 이름에서 나오는) 에 대한 설정대로
		//지정된 URL에 접속 - 응답까지 얻게 됨
//		urlConn.setConnectTimeout(1000);	//예: 연결 시간 타임아웃설정 속성	
		
		urlConn.connect();
		urlConn.disconnect();
		
	}//main
}//end class
