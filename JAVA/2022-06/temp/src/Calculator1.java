
public class Calculator1 {
	
	String color;
	
	//필드
	
	//생성자
	public Calculator1(){
		
		this.areaRectangle(100);		//메소드 호출
		
		Calculator1 newCalculator = new Calculator1();
		newCalculator.areaRectangle(100);
	
		//가능하면, 생성자 블록 내부에서는 필드 초기화 하라.
	}
	
	//메소드
	//정사각형 넓이
	double areaRectangle(double width) {
		System.out.println("Calculator1::areaRectangle(double width) invoked");

//		return width * width;
		
		//밑에거는 하지마. 생성자에서 해 
		this.color = "파란색";			//필드값 초기화
		return 3.14519;			 //원주율파이;
	} // areaRectangle
	
	//직사각형 넓의
	
	//메소드 시그니처의 구성요소 :아래에 기재
	//리턴타입 메소드이름		|--매개변수 선언부--|
	double areaRectangle(double width, double height){
		System.out.println("Calculator1::areaRectangle(double width, double height) invoked");
		return width * height;
		
		
	}//areaRectangle
	
} //end class
