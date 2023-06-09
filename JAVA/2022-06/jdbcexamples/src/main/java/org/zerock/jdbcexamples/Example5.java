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
public class Example5 {

	static final String jdbcDriver ="oracle.jdbc.OracleDriver";
	static final String jdbcTNSNamesUrl = "jdbc:oracle:thin:@xepdb1";
	static final String jdbcOracleCloudUrl = "jdbc:oracle:thin:@iabobij3bs5jnh34_high?TNS_ADMIN=C:/opt/OracleCloudWallet/VFX";
	
	static final String user = "HR";
	static final String passForCloud = "Oracle123456789";
	static final String passForLocal = "oracle";
	
	public static void main(String[] args){
		ResultSet rs =null;
		
		String sql = """
DELETE FROM EMPLOYEES
WHERE employee_id = ?
				""";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcTNSNamesUrl,user,passForLocal); 
			
			try(conn;){
			conn.setAutoCommit(false); // 실패하면 transaction 실행불가
			
			try {
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
		
					try(pstmt;){
						pstmt.setInt(1, 112);
						pstmt.executeUpdate();//DML, DDL, DCL(리턴타입 int)
				
						conn.commit();			//TX 종료 (if success)
					} //try-with-resources 
					
				} catch(SQLException e) {
					conn.rollback();				//TX 종료시점(if failed)
				} //try-catch
			
				}//try-with-resources
		} catch(SQLException e) {
			e.printStackTrace();
		} //try-catch
	}//main
}//end class
