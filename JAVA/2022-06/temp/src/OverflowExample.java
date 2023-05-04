
public class OverflowExample {

	public static void main(String [] args) {
		//코딩시, 변수 선언문을 맨 위에 기술하고,
		//연산식이 포함된 실행문장을 한 행 띄워서 기재합니다.
		
//		int x = 1000000;
//		int y = 1000000;
		
		long x = 1000000;
		long y = 1000000;
		
//		int z = x * y ; // -727379968
		
//		long z = x*y; // 연산의 결과가 타입을 결정하기 때문에 long으로  형변환x
		long z = x*y ; //강제형변환이 먼저? 곱셈이 먼저?우선순위? 
		
		System.out.println(z); // 문법적 오류 x , 오버플로우 21억 넘는다.
	}
}
