package Nov14;

public class Driver {

	public Driver(){
		;;
	}//default constructor
	
	public void drive(Bicycle bicycle) { //자전거 객체넘겨주기, 사람과 전자계산기 클래스 관계 add 호출하기 위함
		bicycle.drive();
	}//drive
	
	//좌회전 시키기
	public void turnLeft(Bicycle bicycle) {
		bicycle.turnLeft();
	}//turnLeft
}
