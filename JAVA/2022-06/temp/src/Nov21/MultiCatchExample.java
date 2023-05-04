package Nov21;

import java.io.IOException;

import lombok.extern.log4j.Log4j2;

@Log4j2

public class MultiCatchExample {
public static void main(String[] args) {
	

	try {
		String data1 = args[0];
		String data2 = args[1];
		
		int value1 = Integer.parseInt(data1);
		int value2 = Integer.parseInt(data2);
		
		int result = value1 + value2 ;
		
		log.info(data1 + "+" + data2 + "=" + result);
	} catch(ArrayIndexOutOfBoundsException | NumberFormatException | NullPointerException e) {
		e.printStackTrace();
		
		try {
			log.error("tf");
		}catch(Exception e1) {;;}
		
		
		log.error("실행 매개값의 수가 부족하거나 숫자로 변환할 수 없습니다.");
	} catch (Exception e) {
		e.printStackTrace();
		
		log.error("알 수 없는 예외 발생");
	} finally {
		log.info("다시 실행하세요");
	} //try-catch-finally

} //main
//
//private static void staticMethod() throws NumberFormatException{
//	;;
//} //staticMethod()

private static int staticMethod(String number) 
		throws IOException{
//return Integer.parseInt(number);

	//강제로 개발자가 지정한 예외를 만드렁 throw 하는 구문에 대해 배우자
	
	if(number.equals("100")) {		//runtime Exception
		throw new NumberFormatException("100");
	} else if(number.equals("200")) {
		throw new IllegalArgumentException("200"); //runtime Exception
	} else if(number.equals("300")) {
		throw new IOException("300"); //			//Checked Exception
	}
	return 0;
	
} //staticMethod()


}//end class
