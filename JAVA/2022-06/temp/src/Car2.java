
class Car2 {

	//1. 필드
	int speed;
	
	//2. 생성자
	Car2 () {	
		;;					//pass
	} // 기본 생성자
	
	//3. 메소드
	int getSpeed() {
		System.out.println("Car2::getSpeed() invoked.");
		
			return speed;
			
	} //getSpeed
	 
	//개발하는 방법을 알려드립니다. 	#1(앞으로 계속 번호가 증가됩니다.)
	//내가 호출할 메소드 시그니쳐를 어떻게 확인할 수 있을까?
	//		(1) 해당 생성자나 메소드 위에 마우스 hovering
	//		(2) 해당 생성자나 메소드를 선택한 후에 F1 키를 누름(F1 help view)
	
	void keyTurnOn() {
		
		System.out.println("Car2::keyTurnOn() invoked.");
		
		System.out.println("키를 돌립니다.");
	} // KeyTurnOn
	
	void run() {
		System.out.println("Car2::run() invoked.");
		
		for(int i = 10; i <= 50; i += 10) {		//10씩 증가. 
			this.speed = i;				//this 붙이면 필드값인지 분별 가능
			
			System.out.println("달립니다.(시속:" + this.speed + "km/h)");
		} // for
	} // run
	
} // end class

