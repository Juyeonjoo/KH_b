package bicycle;

public class Bicycle {

	// ---------------- 1. 생성자

	// ------------------(1) 고유속성 필드

	String brand;         // 브랜드
	String model;         // 모델
	String color;         // 색깔
	String material;      // 재질
	double   weight;         // 무게
	int price;            // 가격

	// ------------------(2) 상태 필드

	int speed;             // 속도
	int gearLevel;         // 변속 기어
	String direction;      // 핸들 방향
	int chairHeight;      // 안장 높이
	boolean bikeLock;      // 자전거 잠금장치

	// ------------------(3) 부품 필드

	GearBox gearBox;      // 변속기
	HandleBar handleBar;   // 핸들
	Pedal pedal;         // 페달
	Seat seat;            // 안장
	Wheel wheel;         // 바퀴
	Brake brake;		//브레이크

	// --------------------------
	// ---------------- 2. 생성자

	public Bicycle(){
		;;
	}

	// ------------ 고유속성필드 생성자
	Bicycle(String brand, String model, String color, String material, double weight, int price) {
		this(brand, model, color, material, weight, price, 0, 0, null, 0, false);
	} // -----------------------------

	// ----------- 상태필드 생성자
	Bicycle(int speed, int gearLevel, String direction, int chairHeight, boolean bikeLock) {
		this(null, null, null, null, 0.0, 0, speed, gearLevel, direction, chairHeight, bikeLock);
	} // -----------------------------

	// ----------- 전체필드 생성자
	Bicycle(String brand, String model, String color, String material, double weight, int price,
			int speed, int gearLevel, String direction, int chairHeight, boolean bikeLock){
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.material = material;
		this.weight = weight;
		this.price = price;
		this.speed = speed;
		this.gearLevel = gearLevel;
		this.direction = direction;
		this.chairHeight = chairHeight;
		this.bikeLock = bikeLock;
	} // -----------------------------


} //end class

