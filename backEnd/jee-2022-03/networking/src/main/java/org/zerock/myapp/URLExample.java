package org.zerock.myapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class URLExample {

	public static void main(String[] args) throws IOException {
		
		String urlString = "https://www.google.co.kr";
		URL url = new URL(urlString);
		log.info("1. url: {}, type:{} ", url, url.getClass().getName());
		
//		===URL 객체를 통해서 지정된 주소에 대한 다양한 정보 획득 가능
		log.info("\t+ getAuthority: {}", url.getAuthority());
		log.info("\t+ getProtocol: {}", url.getProtocol());
		log.info("\t+ getHost: {}", url.getHost());
		log.info("\t+ getPort: {}", url.getPort());// getPort: -1
		log.info("\t+ getDefaultPort: {}", url.getDefaultPort());
		log.info("\t+ getFile: {}", url.getFile());
		log.info("\t+ getPath: {}", url.getPath());
		log.info("\t+ getQuery: {}", url.getQuery());
		log.info("\t+ getRef: {}", url.getRef());
		log.info("\t+ getUserInfo: {}", url.getUserInfo());
		log.info("\t+ getContent: {}", url.getContent());
		
//		--- URL.getContent() 메소드가 반환한 바이트 기반의 입력스트림을 통해
//			지정된 URL의 응답데이터(정확히는 HTTP response메시지) 읽어서 출력해보자
		/*
		@Cleanup InputStream is = (InputStream) url.getContent();
		@Cleanup BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String line = null;
		while((line=br.readLine()) !=null){
			System.out.println(line);
		}
		*/
		//다음의 기능이 URL 객체에서 가장 중요
		URLConnection urlConn= url.openConnection();		// ***공공데이터 포털 연계시 사용
		log.info("1. conn:{}", urlConn);
		log.info("2. type:{}", urlConn.getClass().getName());
		
		HttpURLConnection httpUrlConn=(HttpURLConnection) urlConn;
		HttpsURLConnection httpsUrlCon = (HttpsURLConnection) urlConn;
		
	}//main
}//end class
