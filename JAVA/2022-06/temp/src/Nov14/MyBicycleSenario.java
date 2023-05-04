package Nov14;

public class MyBicycleSenario {

	public static void main(String[] args) {
		
		//Step.1 부품객체 생성
		KumhoFrontTire frontTire = new KumhoFrontTire();
		KumhoHandle handle = new KumhoHandle();
		
		//Step.2 완성자전거 객체 생성
		Bicycle bicycle = new Bicycle(frontTire, handle);
		
		//Step.3 각 실제 부품이 어떤 자전거객체에 부품이 되었는지 설정
		handle.setBicycle(bicycle);
		frontTire.setBicycle(bicycle);
		
		//Step.4 드라이버(운전자) 생성
		Driver driver = new Driver();
		driver.drive(bicycle); // 자전거를 탄다.
		
	}//main
}//end class
