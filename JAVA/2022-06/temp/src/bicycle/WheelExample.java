package bicycle;

public class WheelExample {

	public static void main(String[] args) {
		Wheel whel = new Wheel();

		whel.air = 30;

		boolean airCondition = whel.isAirCondition();

		if(airCondition) {
			System.out.println("공기가 빠집니다.");

			whel.run();
		}

		if(whel.isAirCondition()) {
			System.out.println("공기 주입이 필요합니다.");
		}else {
			System.out.println("공기 주입이 불필요합니다.");
		}	//if-else

	}	// main

}	// class
