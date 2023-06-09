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
public class Example3 {

//	static final String jdbcDriver ="oracle.jdbc.driver.OracleDriver";
	static final String jdbcDriver ="oracle.jdbc.OracleDriver";
	
	//2. JDBC url 설정(EZCONNECT 방식)
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
		ResultSet rs =null;
		
//		//Step.1 수행시킬 SQL문장을 문자열로 준비
		String sql = """
				SELECT *
				FROM employees
				-- ? = Bind Variable 
				WHERE salary > ? 
				""";
		try(
				//JAVA7
			//Step.2 Get a Connection By Using TNSNAMES
			Connection conn = DriverManager.getConnection(jdbcTNSNamesUrl,user,passForLocal); 
			//Step.4 PreparedStatement객체 생성
				PreparedStatement pstmt = conn.prepareStatement(sql);	
		) {
			log.info("1. conn: {}", conn);
			log.info("2. pstmt: {}", pstmt);
			
			pstmt.setDouble(1, 1000);
			
//			Step.5 준비된 Statement 객체와 SQL문자열로 실제 SQL문장을 수행 > 서버로 던진다.(Oracle Server로)
			rs = pstmt.executeQuery(); // resultSet이 리턴타입

//			//Step.6 ResultSet 객체에 있는 모든 행들을 추출
			while(rs.next()) {  
				int employeeId = rs.getInt("employee_id"); //컬럼의 타입별로 getInt, getDouble...getDate,getString 등
						//컬럼 순번으로 정렬x 얻지도 말고 '이름'으로 얻자
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				Timestamp hireDate = rs.getTimestamp("HIRE_DATE");
				double salary = rs.getDouble("SALARY");
				
				log.info("employeeId: {}, firstName: {}, lastName: {}, hireDate: {}, salary: {}",
						employeeId, firstName, lastName, hireDate, salary);
			}//while	
		} catch(SQLException e) {
			e.printStackTrace();
		} //try-catch
	}//main
}//end class
