package org.zerock.myapp;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class InetAddressExample {

	public static void main(String[] args) throws UnknownHostException {
		
		//IP주소를 표현함, IP주소에 대한 정보를 가지고 있음
		
		//LocalHost? => 우리 자신의 PC/디바이스의 도메인명
//		InetAddress⇒(1) 호스트명 + (2) 할당된 IPv4주소
		InetAddress localhost = InetAddress.getLocalHost(); //IP주소 = 우리 pc/device에 할당된 IPv4주소
															//loopback주소를 의미하는게 아님
		
		//localhost를 통해 얻은 PC이름과 이 PC에 할당되어있는 ip주소
		log.info("1. localhost: {}, type:{}", localhost, localhost.getClass().getName()); 
		
		String hostAddr = localhost.getHostAddress();
		String hostName =localhost.getHostName();
		
		log.info("2. hostAddr:{} ", hostAddr);
		log.info("3. hostName:{} ", hostName);
//		---------------------------------------------
		
		//도메인이름을 주면 DNS 서버에 요청해서 IP주소로 다시 반환해주는 getter메소드
		//getByName메소드는 우리가 인자로 준 도메인 명 ->DNS -> 변환된 IP주소를 가진
		//InetAddress를 되돌려주는 getter메소드
		InetAddress addr = InetAddress.getByName("naver.com"); //name=>domain명을 의미
		log.info("\t+2. addr: {}", addr); //naver.com/223.130.195.95(포트번호 없음)
		//nslookup naver.com 했을 때 나오는 ip주소 중 하나만 반환 
		
		InetAddress[] addrs = InetAddress.getAllByName("naver.com");
		log.info("\t+3. addrs: {} ", Arrays.toString(addrs));
		
		//localhost: 우리 PC/device의 loopback Address 에 대한 특수한 도메인 명
		InetAddress[] myAddrs = InetAddress.getAllByName("localhost");
		log.info("\t+4. myAddrs: {} ", Arrays.toString(myAddrs));
	}//main

}//end class
