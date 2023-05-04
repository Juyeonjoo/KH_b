
public class GarbageValueExample {

	// byte 타입의 도메일 : -128 ~ 127
	public static void main(String[] args)	{
		
		byte var1 = 125; // 1바이트
//		int var2 = 125; // 4바이트
		
		for(int i=0; i<5; i++) { // 총 5번 block 안의 실행문장들을 반복 수행
			var1++; // var1 변수의 값을 1 증가시킴
//			var2++; // var2 변수의 값을 1 증가시킴
//			
			// "\t" : 키보드에서 tab 키를 누른 것과 같은 효과로, 탭문자 입력
			System.out.println("var1: " + var1 );
			
		}//for
		
	}//main
}//end class
//
//var1: 126
//var1: 127
//var1: -128 > 128이 도메인을 넘어가기 때문에 최소값으로 넘어간다.
//var1: -127
//var1: -126
