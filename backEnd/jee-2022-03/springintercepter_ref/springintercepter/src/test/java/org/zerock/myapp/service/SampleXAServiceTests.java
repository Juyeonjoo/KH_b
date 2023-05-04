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

// JUnit 5.XX
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/**/root-*.xml"	
})

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SampleXAServiceTests {
	
	@Setter(onMethod_=@Autowired)     // SampleServiceTest 클래스는 SampleService 클래스를 주입받는다 (진짜 service 객체가 아닌 proxy객체를 주입받는다)
	private SampleXAService xaService;
	
	
	@BeforeAll
	void boforeAll() {
		log.trace("beforeAll() invoked");
		
		assertNotNull(xaService);
		log.info("\t serviceType : {} ", xaService.getClass().getName());  
		log.info("\t service : {}", xaService);
	} // beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("contextLoads")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void contextLoads() throws ServiceException {
		log.trace("contextLoads() invoked");
		
		String testData = "012345678901234567890123456789012345678901234567890123456789"; // 50바이트 크기
		boolean success = this.xaService.register(testData);
		log.info("\t success: {}", success);
		
		
	} // contextLoads

} // end class
