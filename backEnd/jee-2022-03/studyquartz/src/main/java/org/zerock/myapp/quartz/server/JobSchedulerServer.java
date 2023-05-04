package org.zerock.myapp.quartz.server;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.zerock.myapp.quartz.job.AJob;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JobSchedulerServer {

	public static void main(String[] args) throws SchedulerException {
		log.trace("main(args) invoked.");
		//Step.1 AJob에 대한 상세정보 생성
		//JobDetail 객체를 생성해주는 JobBuilder 클래스 이용
		JobDetail detailAJob =
				JobBuilder.newJob(AJob.class).
				withDescription("A Job 에 대한 설명을 넣습니다.").
//				withIdentity("A", "GROUP").//우리가 직접 넣어줌->비정석
				withIdentity(JobKey.jobKey("A", "GROUP")).//정석 
				usingJobData("name", "Ju").
				usingJobData("age", 23).
				build();
		
		//Step.2 AJob에 대한 스케쥴링 정보 생성
		
		//TriggerBuilder를 이용해서, 스케쥴링정보를 가진 Trigger 객체 생성
//		-----------------------------
//		초  분 시  일  월 요일
//		*   *   *   *   *   *
		
//		일(1~31)과 요일(월~일요일)은 함께 동시에 사용 불가
//		-----------------------------
		
//		String cronExpression = "0-10 * * * * ?"; //매분 0초부터 10초까지만 수행
//		String cronExpression = "* 51 * * * ?"; //51분일 때 60초 동안 수행시켜라.
//		String cronExpression = "* * * * * ?";  //매초마다
		String cronExpression = "0 * * * * ?";  //매 분 마다 
		Trigger triggerAJob = 
				TriggerBuilder.newTrigger().
				withSchedule(
						//1st. scheduling method
//						SimpleScheduleBuilder.simpleSchedule().
//							withIntervalInSeconds(3). //지정된 주기
////							repeatForever()			//무한반복
//							withRepeatCount(10)		//유한반복
							
						//2nd. scheduling method -Cron daemon 방식
						CronScheduleBuilder.cronSchedule(cronExpression)
	
				).
				build();
		
		//3. Scheduler 서버에 두 가지 객체 등록
//			(1) JobDetail(detailAJob)
//			(2) Trigger (triggerAJob)
		Scheduler sched = StdSchedulerFactory.getDefaultScheduler();
		sched.scheduleJob(detailAJob, triggerAJob);
		
		//4. Scheduler 서버 수행
		sched.start();
	}//main
}//end class
