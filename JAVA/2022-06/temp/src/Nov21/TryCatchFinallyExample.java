package Nov21;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TryCatchFinallyExample {

	public static void main(String[] args) {
		try {
			log.info("This is a try block.");
			
			String name = null;
			log.info("Length: {} ", name.length());

			Class.forName("java.lang.String2");
		}
		catch (NullPointerException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Throwable t) {
			t.printStackTrace(); 
		}
		 finally {
			log.info("finally");
		} //try catch finally
	}//main
}//end class

//16부터
////clazz 객체를 얻는 3가지 방법 중에 3번째
//Class clazz = Class.forName("java.lang.String2");	//Checked Exception 발생 코
//
//log.info("여긴 try 블록입니다.");
//		} catch(ClassNotFoundException e) {
//e.printStackTrace();			//무조건 스택트레이스(stackTrace)출력
//
////비지니스 로직에서 결정한 예외처리 로직
//log.error("클래스가 존재하지 않습니다.");