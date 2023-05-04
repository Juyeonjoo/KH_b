package Nov11;

public class Computer 	//자식클래스
	extends 			//전자계산기 클래스 상속
	Calculator {		//부모 클래스

	@Override
	double areaCircle(double r) {
		System.out.println("Computer::areaCircle(r) invoked");
		return Math.PI * r * r ;
	} //areaCircle
	
} //end class

	
	

