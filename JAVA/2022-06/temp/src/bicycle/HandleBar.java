package bicycle;

public class HandleBar {

	//1.필드
	// 고유속성 필드
	String brand;			//브랜드명
	String model;			//모델명
	String color;			//색깔
	String material;		//재료(Aluminum, Carbon Fiber,Steel...)
	double	weight;			//무게
	int price;				//가격
	boolean isBasket;		//핸들 바구니 여부

	//상태 필드
	String direction;		//핸들의 방향: 왼쪽,오른쪽,정면

	int directionLevel;		//range -3 ~ 3, 0 정면, -1
	int degree;				//핸들의 각도(왼쪽 30도, 오른쪽 30도)

	static int maxDegree;
	static int minDegree;

	boolean isBroken;
	//	==============================================================

	static {

		HandleBar.maxDegree = 45;
		HandleBar.minDegree = -45;
	}

	//	==============================================================

	//2. 생성자
	public HandleBar(){
		;;
	} // 기본 생성자

	HandleBar(String brand, String model, String color, String material, double weight, int price, boolean isBasket) {
		this(brand, model, color, material, weight, price, isBasket, null, 0);
	} // 고유속성 필드 생성자

	HandleBar(String direction, int degree){
		this(null, null,null, null, 0.0, 0, false, direction, degree);
	} // 상태 필드 생성자

	HandleBar(String brand, String model, String color, String material, double weight, int price, boolean isBasket, String direction, int degree){
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.material = material;
		this.weight = weight;
		this.price = price;
		this.isBasket = isBasket;
		this.direction = direction;
		this.degree = degree;
	} // 전체 필드 생성자

	//	==============================================================

	//3. 메소드

	void run (int directionLevel) {
		this.degree = directionLevel * 15;

		if(directionLevel < 0) {
			this.direction ="왼쪽";
		} else if ( directionLevel > 0){
			this.direction = "오른쪽";
		} else {
			this.direction = "정면";
		}

	} // run

	void broken () {
		if(isBroken) {
			this.direction = "정면";
			System.out.println("고장입니다. 핸들이 돌아가지 않습니다. " );
		} else { 
			System.out.println("고장이 아닙니다. 핸들이 정상 작동합니다.");
	} //if-else
	}//broken

} //end class
