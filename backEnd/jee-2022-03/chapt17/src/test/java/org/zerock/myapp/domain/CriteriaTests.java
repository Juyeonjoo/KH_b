package org.zerock.myapp.domain;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CriteriaTests {

	@BeforeAll
	void beforeAll(){	//1회성 전처리
		//1회성 전처리, 가장 중요한 자원을 1회성으로 얻고,
		//계속 쓰기, 보통 필드에서 주입받은 것을 여기다가 넣고 검증
	
		log.trace("beforeAll()");
		
	}//beforeAll
	
	@AfterAll
	void afterAll() { //1회성 후처리
		log.trace("afterAll()");
	}//afterAll()
	
	@BeforeEach
	void beforeEach() { //단위테스트 메소드수행시마다 전처리 수행
		log.trace("beforeEach()");
	}//beforeEach()
	
	@AfterEach
	void afterEach() { //단위테스트 메소드수행시마다 후처리 수행
		log.trace("afterEach()");
	}//afterEach()
	
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("contextloads")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void contextloads() {
		log.trace("contextloads invoked");
		
		Criteria cri = new Criteria();
		cri.setCurrPage(3);
		cri.setAmount(20);
		cri.setPagesPerPage(10);
		
		//검색기느잉 추가될 경우에 설정
//		cri.setType("작성자");//검색기능 타입, 아직 구현하지 않을거라서
//		cri.setKeyword("대한민국");
		
		//얘가 다국어 문자도 제대로 지원해줄까?
		String queryString = cri.getPagingUri();
		log.trace("\t+queryString:{}", queryString);
		
		
	}//
}//end class
