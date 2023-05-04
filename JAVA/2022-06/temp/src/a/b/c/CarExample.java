package a.b.c;

public class CarExample {

	public static void main(String[] args) {
		
		Car myCar = new Car();
		
		//잘못된 속도 변경
		myCar.setSpeed(-50);
		
		System.out.println("현재 속도 : " + myCar.getSpeed());
		
		//올바른 속도 변경
		myCar.setSpeed(60);
		
		//멈춤
		if(!myCar.isStop()) { // 자동차가 멈췄습니까?
			myCar.setStop(true);
		} //if
		System.out.println("현재 속도 :" + myCar.getSpeed());
 	} // main

} //end class
