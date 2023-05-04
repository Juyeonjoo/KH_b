package org.zerock.myapp.controller;

import java.util.Objects;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.myapp.domain.SampleDTO;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@RequestMapping("/reqentity")
@RestController
public class ResponseEntityController implements InitializingBean{
	//핵심: 스프링이 제공하는 제네릭 클래스인 ResponseEntity<T>의
	//용법에 대해서 배우자!!!
	
	@Inject
	private DataSource dataSource;
	
	@Override
	public void afterPropertiesSet() throws Exception{ //사전처리용
		log.trace("afterPropertiesSet() invoked");
		
		Objects.requireNonNull(this.dataSource);
		log.info("\t+this.dataSource", this.dataSource);

	}//afterPropertiesSet
	
	@GetMapping(path="/check", 
			//아래 2개 이름의 전송파라미터는 반드시 들어와야 된다는 제약조건 표시
			params={"height", "weight"},
			produces= {MediaType.APPLICATION_JSON_VALUE}
			)
	
	public ResponseEntity<SampleDTO> check (Double height, Double weight){
		log.trace("check({}, {} ) invoked", height, weight);
			
		//ResponseEntity객체의 속을 채우기 
		//응답메시지의 상태코드? 추가적으로 무슨 header? 바디에는 sampleDTO를 집어넣겠다는 응답으로써
		//보낸다는 의미.
		
		SampleDTO dto = new SampleDTO();
		dto.setMno(100);
		dto.setFirstName("대한");
		dto.setLastName("민국");

		ResponseEntity<SampleDTO> reponse = null;
		//응답코드부터 정하기
		//ResponseEntity의Bodybuilder
		BodyBuilder bodyBuilder = null;
		
		//Step.1 HTTP Response의 응답코드(HTTP status code) 설정
		if(height < 100) { // 키가 요청을 처리하는데 적합하지 않다면
			bodyBuilder = ResponseEntity.status(HttpStatus.BAD_REQUEST);
		}else {	//키가 요청을 처리하는데 적합하다면
			bodyBuilder = ResponseEntity.status(HttpStatus.OK);
		}//if-else
		
		log.info("\t+bodyBuilder:{}", bodyBuilder);
		
//		-----------------------------------------------------------------
		//Step.2 HTTP response의 header설정
//		-----------------------------------------------------------------
		HttpHeaders headers = new HttpHeaders();
//		headers.add(newHeaderName, newHeaderValue);
		
		headers.add("content-type", "application/xml; charset=utf8");
		
		log.info("\t+ headers: {}", headers);
		
		bodyBuilder.headers(headers);
//		-----------------------------------------------------------------
		//Step.3 HTTP response의 BODY설정
//		-----------------------------------------------------------------
		reponse= bodyBuilder.<SampleDTO>body(dto);
			
		log.info("\t+ResponseEntity<SampleDTO>:{}", reponse);
		
		
		return reponse;
	}//check
	
}//end class
