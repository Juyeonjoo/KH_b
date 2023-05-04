package Nov15;


// Vehicle 운전하는 사람에 해당
public class Driver extends Vehicle { //pojo

	//매개변수의 다형성( == 다형성1 + 다형성 2)
	// 다형성1 : 부모타입의 참조변수 = 모든 자식타입의 객체가 대입 가능
	// 다형성2 : 부모타입의 참조변수를 통해 부모타입의 메소드를 호출했을 때, 
//	자식객체가 호출된 부모 메솓르를 재정의하고 있다면
//	재정의된 자식 객체의 메소드가 무조건 호출(부모 메소드는 가려진다.)
	public void drive(Vehicle vehicle) { //매개변수의 타입이 '부모', 전달인자 어떤 차량을 달릴지 매개변수로 받게되어있음.
		System.out.println("Driver::drive(vehicle)invoked");
		System.out.println("\t + vehicle: " + vehicle);
		vehicle.run();					//다형성1 매개변수의 타입이 부모, 다형성2
	} //drive
} //end class
