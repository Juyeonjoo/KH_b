package Nov11;

public class Calculator {

	
	//원의 면적을 계산해주는 메소드를 가지고 있음
	double areaCircle(double r) { //default 메소드
		System.out.println("Calculator::areaCircle(r) invoked");
	
		//원의 면적 =원주율(파이) x 원의 반지름 제곱
		return 3.14159 * r * r;
	} //areaCircle
	
} // end class
