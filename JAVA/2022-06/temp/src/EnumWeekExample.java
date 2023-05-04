import java.util.Calendar;

public class EnumWeekExample {

	public static void main(String[] args) {
	
		//열거타입의 변수는 초기값으로 null을 사용할 수 있다.
		Week today = null; 	//열거타입인 Week 타입의 변수 선언(null초기화)
		
		//열거상수 사용시에는 해당 열거상수가 선언된 "열거타입명.열거상수명"
		//형태로 아래와 같이 사용가능
		today = Week.MONDAY;//열거상수가 정의된 열거타입이름.열거상수
		today = Week.TUESDAY;
		today = Week.FRIDAY;
		today = Week.SATURDAY;
		today = Week.SUNDAY;
		today = Week.THURSDAY;
		today = Week.WEDNESDAY;
		
//		today = 1;			//XX: Week열거타입에 선언된 열거 상수가 아님
//		today = "Hello";	// 위와 동일
//		
//		===============================
		
//		Season a = null; 
//				
//		a = Season.SPRING;
//		a = Season.SUMMER;
//		a = Season.FALL;
//		a = Season.WINTER;
//		
		//자바 표준라이브러리에 있는 것으로 달력을 만든 클래스 이름이 Calendar
		Calendar cal = Calendar.getInstance(); 		// 달력 객체 생성
		int week = cal.get(Calendar.DAY_OF_WEEK); 	// 달력에서 오늘 요일 획득(숫자로 반환)
		
		switch(week) {
		case 1 : today = Week.SUNDAY; break;
		case 2 : today = Week.MONDAY; break;
		case 3 : today = Week.TUESDAY; break;
		case 4 : today = Week.WEDNESDAY; break;
		case 5 : today = Week.THURSDAY; break;
		case 6 : today = Week.FRIDAY; break;
		case 7 : today = Week.SATURDAY; break;
		
		} //switch 
		
		System.out.println("오늘 요일: " + today );
		
		if(today == Week.SUNDAY) {
			System.out.println("일요일에는 축구를 합니다.");
		} else {
			System.out.println("열심히 자바 공부합니다.");
		} //if else
	
} //main

} // end class
