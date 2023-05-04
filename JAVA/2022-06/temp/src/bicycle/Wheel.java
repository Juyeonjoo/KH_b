package bicycle;

public class Wheel {

	//	===============================
	//    고유속성 필드(전체 동일)
	//===============================

	String brand;		// 휠의 브랜드
	String model;		// 휠의 모델의 종류
	String color;		// 휠의 색상
	String material;	// 재료( 알루미늄 등..)
	double weight;			// 휠의 무게
	int price;			// 가격

	//===============================
	//		상태 필드
	//===============================

	String direction;	// 휠 방향	static
	int air;			// 휠의 공기
	int maxAir;			// 휠의 최대 공기량
	int airCondition;	// 휠 공기 상태
	int cadence;        	//페달 분당 회전수(rpm)	static
	boolean isStep;      	//페달을 밟고 있는지, 안 밟고 있는지	static
	//=================================
	//			 생성자
	//=================================

	public Wheel() {
		;;
	}	// 기본 생성자


	public Wheel(String brand, String model, String color, String material, double weight, int price) {
		this(brand, model, color, material, weight, price, null, 0);
	}	// 고유속성 필드 생성자

	public Wheel(String direction, int air) {

		this(null, null, null, null, 0.0, 0, direction, air);
	}	// 상태필드 생성자


	public Wheel(String brand, String model, String color, String material,
			double weight, int price, String direction, int air) {
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.material = material;
		this.weight = weight;
		this.price = price;
		this.direction = direction;
		this.air = air;
	}	// 전체 생성자

	// =================================
	//    메소드
	//=================================
	void setAir(int air) {
		this.air = air;
	}	//setAir

	boolean isAirCondition() {
		if(air == 0) {
			System.out.println("공기가 없습니다.");
			return false;
		}	//if
		System.out.println("공기가 있습니다.");
		return true;

	}	// isAirCondition

	void run() {
		while(true) {
			if(air > 20) {
				System.out.println("공기량이 " + air + "으로 충분합니다.");
				air = air - 1;

			} else {
				System.out.println("공기량이 " + air + "으로 부족합니다.");

				return;
			}	//if else
		}	//while
	}	//run
}	// class
