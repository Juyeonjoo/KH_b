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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor

// * Spring Framework도 함께 구동 * 
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations= { "file:src/main/webapp/WEB-INF/**/root-context.xml"})


@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class HikariDataSourceTests {
	
	@Setter(onMethod_={@Autowired})
	private DataSource dataSource;  // 의존성주입 대상필드
	
	@BeforeAll()
	void beforeAll() {
		log.trace("beforeAll() invoked");
		
		assertNotNull(this.dataSource);
		log.info("/t this.dataSource : {}", this.dataSource);
	}
	
//	@Disabled
	@Test
	@Order(1)
	@DisplayName("테스트1: To get a jdbc connetion from the data Sourve")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testGetConnection() throws SQLException {
		log.trace(">>>>> testGetConnection() invoked");
		
		@Cleanup
		Connection conn = this.dataSource.getConnection();
		
		Objects.requireNonNull(conn);
		log.info("/t >>>conn : {}", conn);
		
	} // testGetConnection
	
	
//	@Disabled
	@Test
	@Order(2)
	@DisplayName("테스트2: To test a sql using the connection")
	@Timeout(value=1, unit=TimeUnit.SECONDS)
	void testSQL() throws SQLException {
		log.trace(">>>>> testSQL() invoked");
		
		@Cleanup Connection conn = this.dataSource.getConnection();
		@Cleanup Statement stmt = conn.createStatement();
		@Cleanup ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
		
		while(rs.next()) {
			String empno = rs.getString("EMPNO");
			String eName = rs.getString("ENAME");
			String job = rs.getString("JOB");
			
			log.info("({},{},{})",empno, eName, job);
			
		} // while
		
	} // testSQL

} // end class
