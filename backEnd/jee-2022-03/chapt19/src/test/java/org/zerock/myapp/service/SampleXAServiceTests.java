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
import org.zerock.myapp.exception.ServiceException;

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
public class SampleXAServiceTests {
	
	@Setter(onMethod_=@Autowired)
	private SampleXAService service;
	
	@BeforeAll
	void beforeAll() { //1회성 전처리
		log.trace("beforeAll() invoked");
		
		assertNotNull(this.service);
		log.info("this.service", this.service);
		
	}//beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("contextloads")
	@Timeout(value=3, unit=TimeUnit.SECONDS)
	public void contextloads() throws ServiceException {
		log.trace("contextloads() invoked");
		
		String testData = "01234567890123456789012345678901234567890123456789"; //50바이트크기
//		String testData = "012345678901234567890123456789012345678901234567890123456789"; //51바이트크기
		boolean success = this.service.register(testData);
		
		log.info("\t+success:{}", success);
	}//contextloads
}//end class
