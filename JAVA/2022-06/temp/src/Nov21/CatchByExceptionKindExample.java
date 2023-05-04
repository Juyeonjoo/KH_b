package Nov21;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CatchByExceptionKindExample {

	//다중 catch 구문
	public static void main(String[] args) {
		
		try {
			String data1 = args[0];
			String data2 = args[1];
			
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			
			int result = value1 + value2 ;
			
			log.info(data1 + "+" + data2 + "=" + result);
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			
			log.error("실행 매개값의 수가 부족합니다.");
			log.error("[실행 방법]");
			log.error("java CatchByExceptionKindExample num1 num2");
		} catch(NumberFormatException e) {
			e.printStackTrace();
			
			log.error("숫자로 변환할 수 없습니다.");
		} finally {
			log.info("다시 실행하세요.");
		} //try-catch-finally
	}//main
}//end class
