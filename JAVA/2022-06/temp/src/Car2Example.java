
class Car2Example {

	public static void main(String[] args) {
		
		Car2 myCar = new Car2();			//자동차 객체 생성
		
		myCar.keyTurnOn();					//자동차 객체 메소드 호출
		myCar.run();						//자동차 객체 메소드 호출
		
		int speed = myCar.getSpeed();		//자동차 객체 메소드 호출
		
		System.out.println("현재 속도: "+ speed + "km/h");
	}//main
}//end class
