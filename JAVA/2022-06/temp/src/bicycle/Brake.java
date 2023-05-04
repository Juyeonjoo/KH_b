package bicycle;

public class Brake {
	// 1. 필드
	
	// 1-1 공통속성
	String brand;			// 제조사
	String model;			// 모델
	String color;			// 색상
	String material;		// 재질
	double weight;			// 무게
	int price;				// 가격
	
	// 1-2 고유속성
	int adjustment;			// 장력조절 정도 (1~4 단계)
	static int speed;		// 속도
	static int maxSpeed;	// 최대속도
		
	// 1-3 상태
	boolean isbrake;		// 브레이크 작동 여부
	boolean isbroken;		// 고장 여부
	int brakeWear;			// 브레이크 마모도
	
	
	// 2. 정적 초기화
	static {
		Brake.speed = 0;
		Brake.maxSpeed = 40;
	}
	
	// 3. 생성자
	public Brake() {
		;;
	} // 기본 생성자
		
	public Brake(String brand, String model, String color, String material, double weight, int price) {
		this(brand, model, color, material, weight, price, 0, false, false, 0);		
	} // 공통속성 생성자
	
	public Brake(int adjustment) {
		this(null, null, null, null, 0.0, 0, adjustment, false, false, 0);	
	} // 고유속성 생성자
		
	public Brake(boolean isbrake, boolean isbroken, int brakeWear) {
		this(null, null, null, null, 0.0, 0, 0, isbrake, isbrake, brakeWear);
	} // 상태 생성자 - 전체
	
	public Brake(String brand, String model, String color, String material, double weight, int price, int adjustment, boolean isbrake, boolean isbroken, int brakeWear) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.material = material;
		this.weight = weight;
		this.price = price;
		this.adjustment = adjustment;
		this.isbrake = isbrake;
		this.isbroken = isbroken;
		this.brakeWear = brakeWear;
			
	} // 전체속성 생성자
	
	
	// 4. 메소드
	
	// 장력조절 값 설정
	void setadj(int adj) {
		System.out.println("Brake::setadj() invoked.");
		this.adjustment = adj;
	} // setadj
	
	void brakeOn() {
		System.out.println("Brake::brakeOn() invoked.");
		System.out.println("브레이크 작동");
		this.isbrake = true;
	}
	
	void brakeOff() {
		System.out.println("Brake::brakeOff() invoked.");
		System.out.println("브레이크 작동중지");
		this.isbrake = false;
	}
	
	// 브레이크 작동시 상황
	void deceleration() {
		System.out.println("Brake::deceleration() invoked.");
		
		if(this.adjustment == 4) {
			System.out.println("===================");
			System.out.println("급제동!");
			System.out.println("⇑🚲⇑");
			System.out.println("튕겨져 나갔습니다...");
			System.out.println("===================");
			this.isbrake = false;
		}
				
		while(this.isbrake == true & this.isbroken == false) {
			System.out.println("===================");
			for(int i = speed; i >= 0; i -= (10 * this.adjustment) ) {
				speed = i;
				this.brakeWear += (10 * this.adjustment);
//				System.out.println("브레이크 마모도: " + this.brakeWear);
				System.out.println("감속중");
				System.out.println("현재속도: " + i + "km/h");
				System.out.println("===================");				
			} // for
			System.out.println("자전거가 멈췄습니다");
			System.out.println("===================");
			this.isbrake = false;			
		} // while
		
		if(this.isbrake == true & this.isbroken == true) {
			System.out.println("======================================");
			System.out.println("브레이크 고장! 감속이 불가능 합니다.");
			System.out.println("현재속도: " + Brake.speed + "km/h");
			System.out.println("======================================");
			} // if		 
	} // deceleration
	
	// 브레이크 고장 건
	boolean broken() {
		System.out.println("Brake::broken() invoked.");
		System.out.println("브레이크 마모도: " + this.brakeWear);
		
		if(brakeWear < 60) {
			;;
		} else {
			System.out.println("브레이크가 마모되었습니다");
			return isbroken = true;
		}		
		return isbroken = false;
	} // broken

} // end class
