package Nov22;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ThrowExample {

	public static void main(String[] args) {
		try {
			ThrowExample.findClass(); 	//정적멤버는 정적멤버답게
		} catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}//try-catch
		
	}//main 

	
	//이 메소드 수행시 오류가 발생한다면, ClassNotFoundException예외가 발생할 수 있음을
	// 명시적으로 throws절을 통해서 메소드 호출자(호출 메소드)에게 알려줌
	private static void findClass() throws ClassNotFoundException, NumberFormatException {
	Class.forName("java.lang.String2");
	Integer.parseInt("100");

	} //find class 
}
