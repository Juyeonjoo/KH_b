package org.zerock.myapp.quartz.job;

import java.sql.Connection;
import java.sql.SQLException;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.zerock.myapp.quartz.dao.CommonDataSource;

import lombok.Cleanup;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor

public class AJob implements Job {  	//functional interface 구현

	@Override
	public void execute(JobExecutionContext ctx) throws JobExecutionException {
		log.trace("execute(ctx) invoked.");
		
		JobDataMap dataMap = ctx.getJobDetail().getJobDataMap();
		String name = dataMap.getString("name");
		Integer age = dataMap.getInt("age");
		
		log.info("name:{}, age : {}", name, age);
		
		try {
			@Cleanup
			Connection conn = CommonDataSource.getInstance().getConnection();
			
			log.info("\t+conn: {}", conn );
		}catch(SQLException e) {
			throw new JobExecutionException(e);
		}//try-catch
		
	}//execute

}//end class
