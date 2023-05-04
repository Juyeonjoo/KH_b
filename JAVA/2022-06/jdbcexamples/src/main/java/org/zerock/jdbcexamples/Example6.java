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
public class Example6 {

	static final String jdbcDriver ="oracle.jdbc.OracleDriver";
	static final String jdbcTNSNamesUrl = "jdbc:oracle:thin:@xepdb1";
	static final String jdbcOracleCloudUrl = "jdbc:oracle:thin:@iabobij3bs5jnh34_high?TNS_ADMIN=C:/opt/OracleCloudWallet/VFX";
	
	static final String user = "HR";
	static final String passForCloud = "Oracle123456789";
	static final String passForLocal = "oracle";
	
	//2개이상의 커넥션으로 시작된 2개 이상의 TX를 All or nothing 처리하는 것은
	//불가능하다. 왜? 이를 분산TX(줄여서 XA)처리는 반드시 트랜잭션관리작 ㅏ필요하다.
	//분산 TX의 처리는 '트랜잭션관리자'에 의한 "2pc(2단계 커밋)"으로 처리한다.
	public static void main(String[] args){
		ResultSet rs =null;
		
		String sql = """
DELETE FROM EMPLOYEES
WHERE employee_id = ?
				""";
		
		try {
			Connection conn1 = DriverManager.getConnection(jdbcTNSNamesUrl,user,passForLocal); 
			Connection conn2 = DriverManager.getConnection(jdbcTNSNamesUrl,user,passForLocal); 
			
			try(conn1; conn2;){
			conn1.setAutoCommit(false); // 실패하면 transaction 실행불가
			conn2.setAutoCommit(false); 
			
			try {
				
				PreparedStatement pstmt1 = conn1.prepareStatement(sql);
				PreparedStatement pstmt2 = conn2.prepareStatement(sql);
				
					try(pstmt1;pstmt2;){
						//성공
						pstmt1.setInt(1, 112);
						pstmt1.executeUpdate();//DML, DDL, DCL(리턴타입 int)
						conn1.commit();
						
						//실패: FK로 인하여 오류발생하는 실행문장
						pstmt2.setInt(1, 100);
						pstmt2.executeUpdate();
//						
//									//TX 종료 (if success)
						conn2.commit();		
					} //try-with-resources 
					
				} catch(SQLException e) {
//					conn1.rollback();				//TX 종료시점(if failed)
					conn1.rollback();		
				} //try-catch
			
			}//try-with-resources
		} catch(SQLException e) {
			e.printStackTrace();
		} //try-catch
	}//main
}//end class
