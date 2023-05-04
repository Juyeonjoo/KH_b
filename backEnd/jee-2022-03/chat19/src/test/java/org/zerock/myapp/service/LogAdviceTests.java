package org.zerock.myapp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/**/root-*.xml"
})

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LogAdviceTests {
	
	@Setter(onMethod_=@Autowired)
	private SampleService service;
	
	@BeforeAll
	void beforeAll() { //1회성 전처리
		log.trace("beforeAll() invoked");
		
		assertNotNull(this.service);
		log.trace("\t+this.service :{}", this.service);
		log.trace("type:::this.service:{}",this.service.getClass().getName());
	}//beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("testBeforeAdvice")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	public void testBeforeAdvice() throws Exception {
		log.trace("testBeforeAdvice() invoked");
		
		Integer result = this.service.plus("100", "200");
//		Integer result = this.service.plus("백","백");

		log.info("*******result:{}", result);
	}//testBeforeAdvice
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("testAfterReturningAdvice")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	public void testAfterReturningAdvice() throws Exception {
		log.trace("testAfterReturningAdvice() invoked");
		
		Integer result = this.service.plus("100", "200");
//		Integer result = this.service.plus("백","백");

		log.info("*******result:{}", result);
	}//testAfterReturningAdvice
	
	
//	@Disabled
	@Test
	@Order(3)
	@DisplayName("testAfterThrowingAdvice")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	public void testAfterThrowingAdvice() throws Exception {
		log.trace("testAfterThrowingAdvice() invoked");	
//		Integer result = this.service.plus("100", "200");
		Integer result = this.service.plus("백","이백");
		//Integer로 변형하려다가 오류나겠지

		log.info("*******result:{}", result);
	}//testAfterThrowingAdvice
	
//	@Disabled
	@Test
	@Order(4)
	@DisplayName("testAfterAdvice")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	public void testAfterAdvice() throws Exception {
		log.trace("testAfterAdvice() invoked");	
		
//		Integer result = this.service.plus("100", "200");	//정상처리
		Integer result = this.service.plus("백","이백");	//오류

		log.info("*******result:{}", result);
	}//testAfterAdvice
	
	
//	@Disabled
	@Test
	@Order(5)
	@DisplayName("testAroundAdvice")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	public void testAroundAdvice() throws Exception {
		log.trace("testAfterAdvice() invoked");	
		
		Integer result = this.service.plus("100", "200");	//정상처리
//		Integer result = this.service.plus("백","이백");	//오류

		log.info("*******result:{}", result);
	}//testAroundAdvice
	
}//end class
