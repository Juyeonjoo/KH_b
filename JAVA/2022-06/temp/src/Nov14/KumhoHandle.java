package Nov14;

public final class KumhoHandle extends Handle { //부모타입 아니고, 실제 부품 클래스 
	
	private Bicycle bicycle; // 필드로 갖고있고 

	public KumhoHandle() {
		;;
	} //default constructor
	
	public void setBicycle(Bicycle bicycle) { //자전거가먼저 생성되는게 아니라 각 부품 먼저 생성
		this.bicycle = bicycle;					//내가 어느 자전거에 
	} //setBicycle

	//규격구현
	@Override
	public void turnLeft() { //규격구현
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.LEFT);
	} 	//turnLeft() 
	
	@Override
	public void turnRight(){ 
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.RIGHT);
	} // turnRight() 	
	
	@Override
	public void goAhead() { 
		FrontTire frontTire = this.bicycle.getFrontTire();
		frontTire.roll(Direction.GO);
	} 	//goAhead()
	

	
} // end class
