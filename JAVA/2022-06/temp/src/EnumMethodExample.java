
public class EnumMethodExample {

	
	//열거타입에 선언된 각각의 열거상수는 바로 힙에 생성되는 객체
	//객체란 속성과 행위(기능, 메소드)을 가진다.
	//본 예제는 열거타입에서 사용가능한 행위(기능,메소드)에 대해 알아보는 예제
	public static void main(String[] args) {
		
		Week today = Week.SUNDAY; 	//열거타입의 변수 선언 및 열거상수로 초기화
		String name = today.name(); // name() 메소드(객체의 행위, 기능) 수행
		System.out.println(name); 	//SUNDAY 과연 name() 메소드의 결과는 무엇?
		System.out.println(today);	//SUNDAY,
		
//		--------------------------------
//		
//		2. ordinal() 메소드
		int ordinal = today.ordinal();
		System.out.println(ordinal);//6 몇번째로 선언된 상수냐, 0부터 시작
//		
//		--------------------------------
		
		//3. compareTo() 메소드
		

		Week day1 = Week.MONDAY;
		Week day2 = Week.WEDNESDAY;
		
//						기준 		비교
		int result1 = day1.compareTo(day2);	// 0
		int result2 = day2.compareTo(day1);	//2
		int result3 = day2.compareTo(day2);	//2
		
		System.out.println(">> day1: " + day1.ordinal());
		System.out.println(">> day2: " + day2.ordinal());
		System.out.println("1. result1 = " + result1); // -2 두 날짜간의 차이.
		System.out.println("2. result2 = " + result2); //2
		System.out.println("2. result2 = " + result3);
//		--------------------------------
		//valueOf() 메소드
		
		Week weekday = Week.valueOf("SUNDAY");
		
		if((weekday == Week.SATURDAY) || (weekday ==  Week.SUNDAY)) {
			System.out.println("주말 이군요");
		} else {
			System.out.println("평일 이군요");
		} //if else
//		--------------------------------		
		

		if (args.length ==1) {
			String strDay = args[0];	//**프로그램 전달인자를 이용하여, 변수의 초기값으로 문자열 전달
			Week weekDay2 = Week.valueOf(strDay); //진짜 열거상수로 바꾸어준다.
			
			if(weekDay2 == Week.SATURDAY || weekDay2 == Week.SUNDAY) {
				System.out.println("주말 이군요");
				} else {
						System.out.println("평일 이군요");
	}

}
		
//		--------------------------------		
		
		//values(메소드)
		
		Week[] days = Week.values(); // 열거타입에 선언된 모든 열거상수를 '배열'로 변환, Weeks 타입에 배열
		
		for(Week day : days) { 
				System.out.println(day);
			
		} //enhanced for

	} // main
}// end class