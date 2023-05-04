package Nov15;

public class DriverExample {

	public static void main(String[] args) {
		
		//step1. 운전자 객체 생성
		Driver driver = new Driver();
		
		//step2. Vehicle의 자식타입 객체 생성
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		//Step3. 자식 객체를 Vehicle 부모 타입의 매개변수에 전달인자값으로 전달
		driver.drive(bus);
		driver.drive(taxi);
	} // main
} // end class
