package Nov25;

import java.util.Arrays;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class TTT {

	public static void main(String... args) {
		TTT.staticMethod();		//전달인자 개수=0 (ok)
		TTT.staticMethod(1);		//전달인자 개수=1 (ok)
		TTT.staticMethod(1, 2);		//전달인자 개수= 2(ok)
		TTT.staticMethod(1, 2,3 );	//전달인자 개수=3		=> 쉼표구분자
	
		int[] intArr = {1,2,3,4,5};
		TTT.staticMethod(intArr);		//전달인자로 배열 객체를 넘겨주기 가능.
	
		TTT.staticMethod(new int[] {1,2,3,4,5});
	}//main
	
	//"가변 인자" 연산자 :
	//매개변수가 받을 전달인자의 개수가 정해져있지 않도록 해주어서, 
	//0개 이상의 전달인자를 받을 수 있도록 해줌
	//( x > = 0, 여기서 x는 전달인자 개수)
	private static void staticMethod(int... numbers) {
		log.info(Arrays.toString(numbers));
	} //staticMethod
}//end class
