
public class TTT4 {

	public static void main(String[] args) {
		
		String myName = "Yoseph";
		
		myName = null;		// null, 그 어떤 객체의 주소(참조)도 없다. 아무것도 가르키는게 없고
							//아무런 객체의 참조도(주소) 가지고 있지 않다.
		
		String yourName = "Ju";
		
		System.out.println(myName.equals(yourName)); // 객체의 주소가 나오는 것이 아니라 문자열 객체 구성자가 나옴
													// 실행이 안된다.java.lang.NullPointerException: 예외 메시지	
		//yourName에는 유효한 객체의 주소가 있다.
		//myName에는 유효한 참조가 없는데 myName에 equals를 하니 오류가 난다.
		
	}
}
