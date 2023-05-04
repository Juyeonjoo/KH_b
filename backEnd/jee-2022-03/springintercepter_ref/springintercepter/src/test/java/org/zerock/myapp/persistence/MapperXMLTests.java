package org.zerock.myapp.persistence;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.apache.ibatis.session.Configuration;
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
import org.zerock.myapp.mapper.TimeMapper;

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

public class MapperXMLTests {

	@Setter(onMethod_= {@Autowired})
	private SqlSessionFactory sqlSessionfactory;
	
	@BeforeAll()
	void beforeAll() {
		log.trace("beforeAll() invoked");
		
		assert this.sqlSessionfactory != null;
		log.info("\t this.sqlSessionfactory : {}", this.sqlSessionfactory);
	}

//	Disabled
	@Test
	@Order(1)
	@DisplayName("Test1: testGetNow")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testGetNow() {
		log.trace("testGetNow() invoked");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionfactory.openSession();
		
		TimeMapper mapper = sqlSession.getMapper(TimeMapper.class);
		Objects.requireNonNull(mapper);
		
		Date now = mapper.getNow();
		log.info("\t >>>>now: {}", now);
	} // testGetNow
	
	@Test
	@Order(1)
	@DisplayName("Test2: testGetNow")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testGetNowByXMLMapper() { // mybatis의 설정파일을 등록하지 않았을 때에도(root-context.xml 파일에  <property name="configLocation" value="classpath:mybatis-config.xml"  /> 없을경우
						// Mapper 인터페이스를 동적으로 Mapper Registry 등록해서 사용하는 방법
		log.trace("testGetNowByXMLMapper() invoked");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionfactory.openSession();
		
		String mapperedStatement = "SQL1Mapper"+".getNow2";
		log.info("\t >>>>mapperedStatement: {}", mapperedStatement);
		
		Date date = sqlSession.selectOne(mapperedStatement);
		
		log.info(">>>>> date : {}",date);
		
	} // testGetNow
	
} // end class
