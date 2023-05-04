
public class Car4 {

	//1. 필드 (가. 고유속성 나. 상태 다. 부품필드)
	int speed; 		//상태필드 > 인스턴스 필드
	
	//2. 생성자
	public Car4 () { ;;} 
	//기본생성자
	
	//3. 메소드
	void run() { //인스턴스메소드
		System.out.println(speed + "으로 달립니다." );
		
	} // run
	
	//대전제: 인스턴스 멤버 = > 모든 유형의 멤버를 사용 가능
	//			정적 멤버 = > 오로지 정적 멤버만 사용 가능
	
	public static void main(String[] args) { // 실행진입점
		Car4 myCar = new Car4();
		myCar.speed = 60;		//속도변경
		myCar.run();			//달리라, 인스턴스 메소드 호출
	
//		speed =60; // xx : 객체생성없이는 사용불가인 인스턴스 필드 
//		run(); 		//xx : 객체생성없이는 호출불가인 인스턴스 메소드 
	}//main
}//end class
