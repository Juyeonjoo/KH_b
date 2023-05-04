
public class Car3 {

	//1. 필드
	String model;
	int speed;
	
	
	//2. 생성자					//기본생성자는 필요 없어 선언x
	
	Car3(String model){
		this.model = model;
	} // Constructor
	
	//3. 메소드
	void setSpeed(int speed) {	//현재 속도 설정
		this.speed = speed;
	} // setSpeed
	
	void run() {				//자동차를 달리게 하는 메소드
		for(int i = 10; i <= 50; i+=10) {	//10 단위로 속도 증가(증감식)
			this.setSpeed(i); //같은 클래스 내부의 다른 메소드 호출:this.메소드
			
			System.out.println( 	//같은 클래스 내부의 필드 사용: this.필드
					this.model + 
					"가 달립니다.(시속:" + 
					this.speed +	//같은 클래스 내부의 필드 사용: this.필드
					"kh/h)"
				);
		}//for
	}//run
}//end class
