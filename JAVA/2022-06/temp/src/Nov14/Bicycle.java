package Nov14;

public class Bicycle { // 완성객체인 자전거 입장에서
	
	//부품 필드(규격) : 부모타입으로 선언 => 다형성1을 이용해서 자식 부품 객체 대입

	private FrontTire frontTire;
	private Handle handle;
	
//					--------------------------
	public Bicycle(FrontTire frontTire, Handle handle) {
		System.out.println("Bicycle::constructor(frontTire, handle) invoked");
		this.frontTire = frontTire;
		this.handle = handle;
	
	} // constructor
	
	public FrontTire getFrontTire() {
		System.out.println("Bicycle::getFrontTire() invoked.");
		return this.frontTire;
	}

	public Handle getHandle() {
		System.out.println("Bicycle::getHandle() invoked.");
		return this.handle;
	}
	
	public void drive() {
		System.out.println("Bicycle::drive() invoked.");
		//Step1. 페달의 press()메소드 호출
	}//drive
	
	public void turnLeft() {
		System.out.println("turnLeft::turnLeft() invoked.");
		this.handle.turnLeft(); 		// 좌회전 규격 메소드 호출
	} // turnLeft


}//end class
