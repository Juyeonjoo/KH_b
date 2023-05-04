package Nov18;


public class NullPointerExceptionExample {

	//Runtime Exception : 자바 컴파일러가 체크하지 않는 예외에 대한 예제
	//					
	public static void main(String[] args) {
		String data = null;
		NullPointerException e = null;
		
		System.out.println(data.toString()); 	//NullPointerException
				
	}//main
}//end class
