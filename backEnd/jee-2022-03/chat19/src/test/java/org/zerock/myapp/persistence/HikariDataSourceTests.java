package org.zerock.myapp.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

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
public class HikariDataSourceTests {

	//여기다가 빈으로 주입해달라.빈즈컨테이너에 이 테스트클래스도 
	@Setter(onMethod_= @Autowired)
	private DataSource dataSource;		//의존성주입 대상필드
	
	@BeforeAll
	void beforeAll(){//1회성 전처리만
		log.trace("@BeforeAll() invoked.");
		
		assertNotNull(this.dataSource);
		log.info("\t+this.dataSource:{}", this.dataSource);
	}//beforeAll
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("Test1: to get a Connection from the Data Source")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testGetConnection() throws SQLException {
		log.trace("testGetConnection() invoked");
		
		@Cleanup
		Connection conn = this.dataSource.getConnection();
		
		Objects.requireNonNull(conn);
		log.info("\t+conn:{}", conn);
		
	}//testGetConnection
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("Test2: to test a SQL using the connection")
	@Timeout(value=5, unit=TimeUnit.SECONDS)
	void testSQL() throws SQLException {
		log.trace("testSQL() invoked");
		
		
		@Cleanup Connection conn = this.dataSource.getConnection();
		@Cleanup Statement stmt = conn.createStatement();
		@Cleanup ResultSet rs =stmt.executeQuery("SELECT * FROM employees");
		
		while(rs.next()) {
			String empId = rs.getString("EMPLOYEE_ID");
			String fName = rs.getString("FIRST_NAME");
			String lName = rs.getString("LAST_NAME");
			String email = rs.getString("EMAIL");
			String phoneNo = rs.getString("PHONE_NUMBER");
			
			String hireDt = rs.getString("HIRE_DATE");
			String jobId = rs.getString("JOB_ID");
			String sal = rs.getString("SALARY");
			String commPct = rs.getString("COMMISSION_PCT");
			String deptId = rs.getString("DEPARTMENT_ID");
			
			log.info("({},{},{},{},{},{},{},{},{},{})",empId,fName, lName, email, phoneNo,
					hireDt, jobId, sal, commPct, deptId
					);
					
		}//while
	}//testSQL
	
	
}