package Nov11;

public class Tire {

	//1. 필드(고유속성, 상태, 부품)
	public int maxRotation;			//최대 회전수(최대 수명)
	public int accumulatedRotation;	// 누적 회전수
	public String location;			//타이어의 위치
	
	//2. 생성자
	public Tire(String location, int maxRotation) { //2개의 인스턴스필드 초기화
		this.location = location;
		this.maxRotation = maxRotation;
	}//Constructor
	
	//3. 메소드
	public boolean roll() {
		++accumulatedRotation;
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " Tire 수명 " + (maxRotation-accumulatedRotation) + "회");
		
			return true;
		} else {
			System.out.println("*** " + location + " Tire 펑크 ***");
		
			return false;
		} //if-else
		
	}//roll()
} //end class
