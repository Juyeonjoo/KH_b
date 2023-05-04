
public class StringEqualExample {

	public static void main(String[] args) {
		
		//대전제: 동일한 문자로 구서오딘 "문자열 리터럴"은 힙영역에 오로지 "단 한번만"생성
		//			되고 이 문자열 객체의 주소가 공유된다.
		String strVar1 = "신민철"; //문자열("신민철", String)타입의 객체의 주소 보관
		String strVar2 = "신민철";//문자열("신민철", String)타입의 객체의 주소 보관
		//
		if(strVar1 == strVar2) { //동등비교연산자(같냐?)로 비교
			System.out.println("strVar1과 strVar2는 참조(=객체의 주소)가 같음");
		} else {
								//다르면
			System.out.println("strVar1과 strVar2는 참조(=객체의 주소)가 다름" );
			
		}// if-else
		
//		===============================
		//String.equals(String): 두 문자열의 구성들이 같은가?(주소따지지X_ 
		if(strVar1.equals("Yoseph") ) {//두개의 문자열이 같은가?..참이면
			System.out.println("strVar1과 strVar2는 문자열이 같음");
		}
//		===============================
		
		String strVar3 = new String("신민철"); //새로운 신민철 new 문자열 객체를 새로 생성
		String strVar4 = new String("신민철"); //새로운 신민철 new 문자열 객체를 새로 생성
		
		//String type의 주소를 찍어보자
		System.out.println("1. strVar3: " + strVar3); //1. strVar3: 신민철주소가 안나옴
		System.out.println("1. strVar4: " + strVar4);// 1. strVar4: 신민철
		
		if(strVar3 == strVar4) { // 객체마다 주소가 고유하다. 고유한 주소 비교하는 것.
			System.out.println("strVar3과 starVar4는 참조가 같음");
		} else {
			System.out.println("strVar3과 starVar4는 참조가 다름");
			
		}//if
		if(strVar3.equals(strVar4)) {
			System.out.println("strVar3과 strVar4는 문자열이 같음");
		}
//		===============================
		
		Object obj = new Object(); //Object 타입의 객체를 생성해서 참조변수에 참조(주소)저장
		
		// 소위, 참조변수에 저장되어있는 객체의 주소(참조)를 직접 눈으로 보자.
		System.out.println("*** obj: " + obj); //객체의 주소, 참조 //*** obj: java.lang.Object@5ca881b5
		
	}  //main
} //main

