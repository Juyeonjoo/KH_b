package org.zerock.jdbcexamples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Objects;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Example2 {

	//1. JDBC 구동기(Driver) 역할을 하는 클래스의 FQCN을 알아야 한다.
	//하지만, 이미 DB별로 정해져있다.(아래는 Oracle JDBC Driver의 구동기 클래스
//	static final String jdbcDriver ="oracle.jdbc.driver.OracleDriver";
	static final String jdbcDriver ="oracle.jdbc.OracleDriver";
	
	
	//2. JDBC url 설정(EZCONNECT 방식) ,uniform resource locator(url)
	static final String jdbcEZConnectUrl = "jdbc:oracle:thin:@DESKTOP-L8IL62V:1521/xepdb1";
	
	//2.JDBC url 설정(tnsname 방식)
//	static final String jdbcTNSNamesUrl = "jdbc:oracle:thin:@xepdb1?TNS_ADMIN=C:/u01/oracle/product/18.0.0/dbhomeXE/network/admin";
	static final String jdbcTNSNamesUrl = "jdbc:oracle:thin:@xepdb1";
	
	//3. JDBC url 설정(Oracle Cloud 연결방식) 무조건 tns방식,전자지갑 사용
	static final String jdbcOracleCloudUrl = "jdbc:oracle:thin:@iabobij3bs5jnh34_high?TNS_ADMIN=C:/opt/OracleCloudWallet/VFX";
	
	
	//3. 로그인(인증, Authentication) 정보 제공
	static final String user = "HR";
	static final String passForCloud = "Oracle123456789";
	static final String passForLocal = "oracle";
	
	public static void main(String[] args){
		
		//모두 자원객체, Autocloseable,> 닫아줘야 함
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
		
			//Step.1 Oracle JDBC Driver Class Loading
	//		Class.forName(jdbcDriver); //자동으로 뽑아내서 굳이 안해도 됨.
			
			//Step.2 Get a connection By Using EZConnect
	//		conn = DriverManager.getConnection(jdbcEZConnectUrl,user,passForLocal);
	//		log.info("1. conn: {}", conn);
			
			//Step.2 Get a Connection By Using TNSNAMES // 안됨
			conn = DriverManager.getConnection(jdbcTNSNamesUrl,user,passForLocal);
			log.info("2. conn: {}", conn);
			
			//Step.3 Get a 
	//		conn = DriverManager.getConnection(jdbcOracleCloudUrl,user,passForCloud);
	//		log.info("3. conn: {}", conn);
			
			
			//Step.4 Statement 객체 생성(용도: Dynamic SQL문장을 생성)
			stmt = conn.createStatement(); //return타입이 statement
			log.info("2. stmt: {} ", stmt); 
			
			//Step.5 수행시킬 SQL문장을 문자열로 준비
			String sql = """
					SELECT *
					FROM employees
					WHERE salary >1000 
					""";
		
			//Step.6 준비된 Statement 객체와 SQL문자열로 실제 SQL문장을 수행 > 서버로 던진다.(Oracle Server로)
			rs = stmt.executeQuery(sql); // resultSet이 리턴타입
			log.info("3. rs: {}", rs);
			
			//Step.8 ResultSet 객체에 있는 모든 행들을 추출
			while(rs.next()) {  // 끄집어낼게 있는지.  몇번인지 모름 > while
				//더이상 추출할 행들이 없을 때 까지, 행을 뽑아내는 건 없다.
				//첫 번째 행 이전의 컬럼들이 모여있는 행을 가르키고 있다가 rs.next() 하면 첫 번째 행을 가르킴 
			//추출된 각 행의 컬럼들의 값을 얻어낸다.
				
				int employeeId = rs.getInt("employee_id"); //컬럼의 타입별로 getInt, getDouble...getDate,getString 등
						//컬럼 순번으로 정렬x 얻지도 말고 '이름'으로 얻자
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				Timestamp hireDate = rs.getTimestamp("HIRE_DATE");
				double salary = rs.getDouble("SALARY");
				
				log.info("employeeId: {}, firstName: {}, lastName: {}, hireDate: {}, salary: {}",
						employeeId, firstName, lastName, hireDate, salary);
			}//while
			
			//닫는 순서 반대, null 값인지 확인하는게 좋음
			//JDBC에서는 아래의 3개 자원객체를 닫는 순서가 저앻져있음.
	//		(1)ResultSet.close();
	//		(2)Statement/PreparedStatement.close();
	//		(3)Connection.close();
			
			
			assert rs != null;			//1st. method
			Objects.requireNonNull(rs);	//전문가 2nd. method rs 값이 null이면 예외, 아니면 무사통과
			if(rs !=null) rs.close();	//일반적, 3rd. method
	//		assertNotNull(rs); //4th. method 단 Junit Test Framework 에 속한 메소드. 이건 scoop이 테스트할 때만 쓸 수 있다. 그래서 compiler할때는 못씀
	//		
			
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try{if(rs != null) rs.close();} catch(SQLException e) {;;};
			try{if(stmt != null) stmt.close();} catch(SQLException e) {;;};
			try{if(conn != null) conn.close();} catch(SQLException e) {;;};
		}//try-catch-finally
	}//main
}//end class
