package org.zerock.myapp.quartz.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import lombok.extern.log4j.Log4j2;

@Log4j2

//어디서든 가져다쓸 수 있게 해주기 위해서 어떻게 해야할까?
//이건 web과 상관 없잖아. 
public class CommonDataSource {
	private static final CommonDataSource _self = new CommonDataSource();
	private final DataSource dataSource;
	//static final 의 초기화는 어디서 해야하지?
	//한 번만 만들어주고 계속 사용하면 되니까.
	
	private CommonDataSource() { //외부에서 직접 접근 못하게
		//이 안에서 dataSource생성해주면된다. 
		//싱글톤만들라는 이야기이다.
//		private field 의 private constructor
		
		//hikari datasource 직접쓰는 방식(spring으로 xx)
		HikariConfig conf = new HikariConfig();
		conf.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		conf.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@iabobij3bs5jnh34_high?TNS_ADMIN=C:/opt/OracleCloudWallet/VFX"); 
		conf.setUsername("ADMIN");
		conf.setPassword("Oracle123456789");
		
//		min, max 사이즈 설정
		conf.setMinimumIdle(5);
		conf.setMaximumPoolSize(20);
		
//		-------- hikaridatasource 설정 끝----
		
		this.dataSource = new HikariDataSource(conf);
		Objects.requireNonNull(this.dataSource);
		log.info("\t+this.dataSource : {}", this.dataSource);
	}//default Constructor
	
	public static synchronized CommonDataSource getInstance() {
		return _self;
	}//getInstance()
	
	public Connection getConnection() throws SQLException{//hikaridatasource 가지고 올 수 있도록
		
		return this.dataSource.getConnection();
	}//getConnection()
	
	
	public void close(Connection conn) {
		try{
			conn.close();
		}catch(Exception e) {
			;;
		}//try-catch
	}//close()
}//end class
