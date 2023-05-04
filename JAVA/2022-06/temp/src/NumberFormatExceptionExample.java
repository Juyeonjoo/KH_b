
public class NumberFormatExceptionExample {

	//4번째 실행 예외: NumberFormatException 소개
	public static void main(String[] args) {
		String data1 ="100";
		String data2 = "a100";
		
		//숫자(정수)형태의 문자열 = > 진짜 숫자(정수)로 변환시킴
		int value1 = Integer.parseInt(data1);		//WrapperType의 parseXXX()메소드 호출
		int value2 = Integer.parseInt(data2);		//WrapperType의 parseXXX()메소드 호출
		
		int result = value1 + value2;
		System.out.println(data1 + "+" + data2 + "=" + result);
		
	}//main
}//end class
