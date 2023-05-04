package Nov11;

public class Airplane {

	
	//static이 없는 인스턴스 메소드
	public void land() {
		System.out.println("Airplane::land() invoked.");
	} //land
	
	public void fly() {
		System.out.println("Airplane::fly() invoked.");
	} //fly
	
	public void takeOff() {
		System.out.println("Airplane::takeOff() invoked.");
	}//takeOff
}//end class
