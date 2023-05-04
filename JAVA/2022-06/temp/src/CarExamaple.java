
public class CarExamaple {
	public static void main(String[] args) {
	
		//Car 클래스의 인스턴스(객체)생성
		Car myCar = new Car();
		
		//setGas 메소드 호출(Give and Take 잊지말기)
		myCar.setGas(5);	//Car의 setGas()메소드 호출
		
		//isLeftGas 메소드 호출
		boolean gasState = myCar.isLeftGas(); 
		
//		=========================
		
		//연료 여부
		if(gasState) {
			
			System.out.println("출발합니다.");
			
			myCar.run();			//Car의 run() 메소드 호출, 
		} // if
		
		//연료가 남아있다면?
		if(myCar.isLeftGas()) {		//Car의 isLeftGas() 메소드 호출
			System.out.println("gas를 줄입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		}
		
	} // main 
} // end class
