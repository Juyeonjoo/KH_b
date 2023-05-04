
public class Calculator1Example1 {

	public static void main(String[] args) {
		
		//전자계산기 객체 생성
		Calculator1 myCalcu = new Calculator1();
		
		// 정사각형 넓이 구하기
		double result1 = myCalcu.areaRectangle(10);
//		double result1 = myCalcu.areaRectangle(10, 10);
		
		// 직사각형 넓이 구하기
		double result2 = myCalcu.areaRectangle(10, 20);
		
		//결과 출력
		System.out.println("정사각형 넓이= " + result1);
		System.out.println("직사각형 넓이= " + result2);
	}
}
