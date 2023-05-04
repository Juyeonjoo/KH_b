package Nov11;

public class KumhoTire extends Tire {

	//필드
	//생성자
	
	public KumhoTire(String location, int maxRotation) {
		super(location, maxRotation);
	} //constructor
	
	//메소드 : 부모인 Tire 타입이 상속해준 roll() 메소드 재정의
	@Override
	public boolean roll() {
		++accumulatedRotation; //부모가 물려준 필드
		if(accumulatedRotation < maxRotation) {
			System.out.println(location + " KumhoTire 수명 " + (maxRotation-accumulatedRotation) + "회");
		
			return true;
		} else {
			System.out.println("*** " + location + " KumhoTire 펑크 ***");
		
			return false;
		} //if-else
	}	//roll()
	
}
