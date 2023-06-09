package org.zerock.myapp.thread;

import java.util.Arrays;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class ExerciseThread01 {

	
	//새로운 스레드(Thread) 생성
	//main이라는 thread, 실행클래스의 entry point 를 치고 들어와서
	//main method가 끝날 때 까지 
	//main method가 끝나면 VM도 죽는다.
	public static void main(String[] args) throws InterruptedException {
		log.trace("main([]) invoked. ", Arrays.toString(args) );
		
		//자바언어에서 스레드(실행흐름)  => 모델링 => java.lang.Thread 클래스
		
//		=============================
		//1. 
		Thread t1 = new Thread(new Task(), "UserThread"); //새로운 스레드의 이름 : Thread-N
		
		//main 스레드가 죽을 때, 함께 같이 따라서 죽는 User Thread=>데몬(daemon)스레드
		t1.setDaemon(true); //Daemon 스레드로 설정
//		=============================
		
//		=============================
		/*
		//2. 익명구현객체 : 익명국현객체로 Runnable 객체 제공 
		//객체를 생성할 수 없는 인터페이스의 객체 생성
		Thread t1 = new Thread( new Runnable() {
			
			@Override
			public void run() {//User스레드의 실행진입점(entry point)
				log.trace("run() invoked");
			}//run
		}, "UserThread");
		*/
//		=============================
		
//		=============================
		//3. lamda
		/*
		Thread t1 = new Thread(()->{
		
		}, "UserThread");
		*/
//		=============================
		
		//그럼 우리가 만든 별도로 만든 thread는 entrypoint가 어디냐
		//개발자가 entry point 제공해야 한다. 
		
		//User 스레드의 실행
		t1.start(); 		//main thread와는 별개로 User thread가 생성/실행 
		
		Thread.sleep(1000 * 5);//5초 동안 main스레드 일시정지, 잠재우기
		log.info("**********main스레드는 죽습니다.....");
	}//main

}//end class


@Log4j2
@NoArgsConstructor
class Task implements Runnable{

	//User Thread's Entry Point
	@Override
	public void run() {
		log.trace("run() invoked.");
		
		//새로운 실행 흐름이 수행할 일련의 자바 실행문장을 여기에 넣으면,
		//User Thread는 이 자바 실행문장을 수행시킴
		//메소드의 끝을 만나면 죽는다. 
		for(int i=1; i<100;i++) {
			log.trace("-UserThread-");
			
			try {
			Thread.sleep(1000*1); //현재 스레드의 실행을 멈추고 잠자기
			}catch(InterruptedException e) {
				;;
			}//try-catch
		}//for
		
		log.info("**********User Thread는 죽습니다.....");
		
	}//run
	
}//Task class
