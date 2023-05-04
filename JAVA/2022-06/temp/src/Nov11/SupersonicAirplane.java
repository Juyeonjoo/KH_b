package Nov11;

//초음속 비행기(자식)
public class SupersonicAirplane 
	extends Airplane {
	
	
	//static final 상수 선언
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 2;
	
	public int flyMode = SupersonicAirplane.NORMAL; //정적멤버답게
	
	@Override
	public void fly() { //메소드 오버라이딩
		System.out.println("SupersonicAirplane::fly() invoked.");
		
		if(flyMode == SupersonicAirplane.SUPERSONIC) {//정적멤버답게
			
			System.out.println("SupersonicAirplane::fly() invoked. 초음속 비행합니다.");
		} else {
			System.out.println("super.fly");
			super.fly(); // 부모, Airplane객체의 fly()메소드 호출
		} //if-else
	}//fly
	
}//end class
