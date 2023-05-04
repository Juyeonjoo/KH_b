package org.zerock.myapp.persistence;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
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
import org.zerock.myapp.mapper.OtherMapper;


import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

//* Spring Framework도 함께 구동 * 
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= { "file:src/main/webapp/WEB-INF/**/root-*.xml"})

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class OtherMapperTests {

	@Setter(onMethod_= {@Autowired})
	private SqlSessionFactory sqlSessionfactory;
	
	@BeforeAll()
	void beforeAll() {
		log.trace("beforeAll() invoked");
		
		assert this.sqlSessionfactory != null;
		log.info("\t this.sqlSessionfactory : {}", this.sqlSessionfactory);
	}

	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("Test1: testGetNow")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testGetNow3() {  // XML 방식
		log.trace("testGetNow() invoked");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionfactory.openSession();
		
		OtherMapper mapper = sqlSession.getMapper(OtherMapper.class);
		Objects.requireNonNull(mapper);
		log.info(">>>> mapper3 : {}", mapper);
		
		// TimeMapper.xml에 등록된 SQL 이용
		Date now = mapper.getNow2();
		log.info("\t >>>> now3: {}", now);
	} // testGetNow
	
} // end class
