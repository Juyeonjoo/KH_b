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
public class Example4 {

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
		
		try(
			Connection conn = DriverManager.getConnection(jdbcTNSNamesUrl,user,passForLocal); 
			PreparedStatement pstmt = conn.prepareStatement(sql);	
		) {
			log.info("1. conn: {}", conn);
			log.info("2. pstmt: {}", pstmt);
	
			pstmt.setInt(1, 111);
			
			int affectedRows= pstmt.executeUpdate();//DML, DDL, DCL(리턴타입 int)
			log.info("affectedRows: {}", affectedRows);
			assert affectedRows == 1; 
			
		} catch(SQLException e) {
			e.printStackTrace();
		} //try-catch
	}//main
}//end class
