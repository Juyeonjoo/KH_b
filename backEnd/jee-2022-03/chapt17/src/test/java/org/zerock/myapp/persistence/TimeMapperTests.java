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

//Spring Framework도 함께 구동
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/**/root-context.xml")

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TimeMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private SqlSessionFactory sqlSessionFactory;
	
	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked");
		
		
		assert this.sqlSessionFactory !=null;
		log.info("\t+this.sqlSessionFactory", this.sqlSessionFactory);
		
//		Objects.requireNonNull(null)
	}//beforeAll
	
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("Test1: to test testGetNow method.")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testGetNowByXMLMapper() {
		log.trace("testSqlSessionFactoryBean() invoked");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		
		String  mappedStatement = "SQL1Mapper"+".getNow2";
		log.info("\t+mappedStatement:{}", mappedStatement);
		
		Date now = sqlSession.selectOne(mappedStatement);
		log.info("\t+now:{}", now);
		
	}//testGetNow() 

//	@Disabled
	@Test
	@Order(2)
	@DisplayName("Test3: To test testGetNow2 method.")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testGetNow2() { //마이바티스의 설정파일을 등록하지 않았을 때에도 Mapper 인터페이스를 동적으로
						// Mapper Registry 에 등록해서 사용하는 법
		log.trace("testGetNow2() invoked");
		
		//Step.1 동적으로 TimeMapper 인터페이스를 Mapper Registry에 등록
		Configuration conf = this.sqlSessionFactory.getConfiguration();
		conf.addMapper(TimeMapper.class); //TimeMapper registry가 동적으로 TimeMapper인터페이스를 추가.
//		conf.addLoadedREsource(String resource);//XML Mapper 동적등록메소드(***)
		
		//Step.2 TimeMapper 인터페이스에 대한 MapperProxy 객체를 얻어서 메소드 호출
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();

		TimeMapper mapper = sqlSession.<TimeMapper>getMapper(TimeMapper.class);
		
		Objects.requireNonNull(mapper);
		log.info("mapper:{}, type:{}", mapper, mapper.getClass().getName());
		
		Date now = mapper.getNow();
		log.info("now:{}", now);
		
	}//testGetNow2() 
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("Test1: to test testGetNow method.")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testgetNo() {
		log.trace("testSqlSessionFactoryBean() invoked");
		
		@Cleanup
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		
		
		String  mappedStatement = "SQL1Mapper"+".getNow2";
		log.info("\t+mappedStatement:{}", mappedStatement);
		
		Date now = sqlSession.selectOne(mappedStatement);
		log.info("\t+now:{}", now);
		
	}//testGetNow() 
	
	
}//end class
