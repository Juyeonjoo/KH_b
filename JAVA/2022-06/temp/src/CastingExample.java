
public class CastingExample {

	public static void main(String[] args) {
		
		int intValue = 44032; //가
		char charValue = (char) intValue; // Lvalue(2) = Rvalue(4) 강제형변환
		
		System.out.println(charValue);
		System.out.println(intValue);
		System.out.println((char)intValue);//출력할때 강제형변환할 수 있다.
		
		//44032 는 2바이트 쓰기 때문에 데이터 유실이 없다.
	
		
		long longValue = 500; //2바이트만 쓰기 때문에 데이터 유실 없음
		intValue = (int) longValue; //현재 intValue가 int intValue = 44032;이므로.
		System.out.println(intValue);
		
		double doubleValue = 3.14;
		intValue = (int) doubleValue;
		
		System.out.println(intValue); //절삭, 소수점이하가 버려짐. 정수 유효자리만 남음
		
//		int a = 44032;
//		String binaryString = Integer.toBinaryString(a);
//		System.out.println(binaryString); //10101100 00000000 2바이트
//	
		
		int a = 10; // 4바이트 
		double b = 5.5;// 8바이트
		double result = a + b; // 작은 타입의 int가 큰 타입의 double로 변환되는 것
		System.out.println(result); // 15.5
	}
}
