package Nov11;

public class Car {

	//1. 필드
	public int speed;
	
	//2.생성자
	public Car() {
		;;
	} //default constructor
	
	//3. 메소드
	public void speedUp() {
		this.speed += 1;	
	} //speedUp() 
	
	//final 메소드 *** : 자식 클래스에서, 메소드 오버라이딩을 허용하지 않겠다.
	public final void stop() { //final 메소드
		System.out.println("차를 멈춤");
		
		this.speed = 0;
	} // stop
	
} //end class
