package Nov22;

import java.util.Scanner;

import lombok.Cleanup;

public class ResourcesExample {

	
	//try-with-resources 블록에 대한 향상된 문법과 상세한 용법
	public static void main(String[] args) throws Exception {
		/*
		//@since JAVA 8
//		try( //<------------------- 이 방향으로 각각의 자원객체를 자동으로 close한다.
//				//@till JAVA 7
//				Resource1 res1 = new Resource1();
//				Resource2 res2 = new Resource2();
//				Resource3 res3 = new Resource3();
//								
//				){
//			
//		} //try-with-resource
		
////		===============
		//@since JAVA 8
		Resource1 res1 = new Resource1();
		Resource2 res2 = new Resource2();
		Resource3 res3 = new Resource3();
//		
		//<------------------- 이 방향으로 각각의 자원객체를 자동으로 close한다.
		try(res1; res2; res3;){
		} //try-with-resource
	*/	
//		//lombok의 자원객체 닫아주는 어노테이션 기반으로 닫자
//
//		try {	
//		@Cleanup		// main block 끝에서 닫힘
//		Resource1 res = new Resource1();
//	}catch(Exception e) {;;}		//자원객체를 close 하다 발생하는 예외는 처리하지 않음
//		
		
		//중간에서 자원객체 활용 코드
//		res.close();			//1.개발자가 직접 close() 메소드 호출하여 닫아줌
								//2. try-with-resources block 사용
								//3. lombok's @Cleanup annotation
//================
		//lombok 자원객체 닫아주는 어노테이션 기반으로 하되,
		//자원객체들 간에 역시 닫는 순서가 정해져있다면?
		
		//닫는 순서: (1) res2 (2) res3 (3) res1
		
//		try {
//			@Cleanup
//			Resource1 res1 = new Resource1();
//			
//		@Cleanup
//		Resource2 res2 = new Resource2();
//		
//		@Cleanup
//		Resource3 res3 = new Resource3();
//		
//		} catch(Exception e) {;;}
//		===========================
		
		
		{
			@Cleanup
			Resource3 res3 = new Resource3();
			
			Scanner scanner = new Scanner(System.in);
			
			int number1 = scanner.nextInt();
			int number2 = scanner.nextInt();
			
			int result = number1 + number2;
			log.info(result);
			
//			int result = 100 + 200;
//			log.info("result");
//			
			throw new Exception("User-defined Exception");
		}//User -defined block
		
//		{
//		@Cleanup
//		Resource1 res1 = new Resource1();
//		}
		
//		{
//			@Cleanup("close")
//			Resource2 res2 = new Resource2();
//		}//User -defined block
		
//
//		try {
//		@Cleanup
//		Resource2 res2 = new Resource2();
//		} catch(Exception e) {;;}
//		
//		try {
//		@Cleanup
//		Resource3 res3 = new Resource3();
//		} catch(Exception e) {;;}
//		
//		try {
//		@Cleanup
//		Resource1 res1 = new Resource1();
//		} catch(Exception e) {;;}
//		

	}//main
}//end class
