package Nov28;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

import lombok.extern.log4j.Log4j2;


@Log4j2
public class PropertiesExample {

	//리소스 번들 파일을 읽어서 메모리 Map 컬렉션으로 구성해주는
	//Map<K,V> 인터페이스의 구현 클래스 중에 Properties 배우자
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//1. Properties Map 객체 생성
		Properties properties = new Properties();
	
		//2. Properties Map 객체가 읽을, 리소스 번들 파일의 경로 획득
		String path = 
				PropertiesExample.		
				class.								//Clazz객체 획득
//				getResource("database.properties"). //지정된 리소스 파일 찾아 URL 객체로 반환
//				getResource("/database.properties").		//바로프로젝트 폴더 밑에 있는 src 소스 폴더를 의미
				getResource("/first/second/database.properties").
				getPath();							//찾아낸 리소스 파일의 절대경로 획득
				
		log.info("0.path: {}", path);
		
		//3. 웹 구현에서 나오는 개념으로 URL Enconding/Decoding중에
		//URL decoding 수행
		path = URLDecoder.decode(path,"utf-8");
		
		//4. 획득한 리소스 번들의 경로를 주어서, PropertiesMap 컬렉션 생성
		// new FileReader(path) : 지정된 경로의 파일에 대한 읽기 객체를 생성
		// 		=> 이 객체를 이용해서 파일의 내용을 읽음
		properties.load(new FileReader(path));		//load가 갖는 매개변수는 : reader 
												//텍스트파일을 read할 때 쓰는 객체 read.
//		지정된 파일을 읽어올 수 있게 하는 FileReader
		
		//5. Properties 객체에서 지정된 이름의 설정정보를 획득/출력
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String name = properties.getProperty("이름");
		
		log.info("driver : " + driver);
		log.info("url : " + url);
		log.info("username : " + username);
		log.info("password : " + password);
		log.info("name : " + name);
		
	}//main
}//end class
