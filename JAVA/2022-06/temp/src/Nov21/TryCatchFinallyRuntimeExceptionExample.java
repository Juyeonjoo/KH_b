package Nov21;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

public class TryCatchFinallyRuntimeExceptionExample {

	
	//다중 catch 구
	public static void main(String[] args) {
		String data1 = null;
		String data2 = null;
		
		try {
			log.info("-- 1st. Exception Handling ---------");
			data1 = args[0];
			data2 = args[1];
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			
			log.error("실행 매개값의 수가 부족합니다.");
			log.error("[실행 방법]");
			log.error("java TryCatchFinallyRuntimeExceptionExample num1 num2");
		
			return;				// *** 그 즉시 메소드 실행 중지
		} // try- catch
		
//		=========================
		try {
			log.info("--2nd. Exception Handling ---------");
		int value1= Integer.parseInt(data1);	//RuntimeException > NumberFormatException
		int value2 = Integer.parseInt(data2);	//RuntimeException > NumberFormatException
		
		int result = value1 + value2;
		
		log.info(data1 + "+"+ data2 + "=" + result);
//		}	catch(NumberFormatException e) {		//실행 예외가 나면?
//			e.printStackTrace();
//	
//		log.info("숫자로 변환할 수 없습니다.");
//		
		} 
		finally {
			log.info("다시 실행하세요.");
		}//try-catch-finally
	}//main
}//end class
