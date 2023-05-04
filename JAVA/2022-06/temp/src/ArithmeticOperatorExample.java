
public class ArithmeticOperatorExample {

	//(대전제) 정수연산식의 결과 => 정수, int 타입으로 가정(시작)
	public static void main(String[] args) {

		int x = 88;
		// x 변수의 값이 짝수인지 홀수인지 판단해보자
		
		int 나머지 = x % 2;
		
		if(x % 2 == 0) {//참이면.. true이면
 			System.out.println("짝수");
			
		} else {
			System.out.println("홀수");
		}
		
//		System.out.println("나머지 = " + 나머지);
		
		//		
//		int v1 = 5;
//		int v2 = 2;
//		
//		int result1= v1 % v2; // 나누셋에서 나머지 구해주는 연산자
//		System.out.println("result1= "+ result1); //result5= 1
//		
//		double result2 =(double) v1 / v2 ; // 정수밖에 못 나오니, 실수타입으로 바꾸기
//		System.out.println("result2= " + result2); //result6= 2.5
//
//		
	}
}
