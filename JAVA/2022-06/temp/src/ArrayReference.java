
public class ArrayReference {

	public static void main(String[] args) { //크기가 3인 1-D배열
		
		String[] strArray = new String[3];
		
		//첫번째와 두번째 원소는 "Java"라는 동일한 문자열 객체의 주소 공유
		strArray[0] = "Java"; //첫번째 원소값 설정
		strArray[1] = "Java";//두번째 원소값 설정
		
		//세번째 원소는 객체생성연산자인 new로 객체를 생성/저장했기 때문에
		//다른 객체의 주소 저장
		strArray[2] = new String("Java");
		
		
		//2개의 참조타입 변수에 대한 동등비교연산자의 의미는
		//2개의 참조타입 변수에 저장된 객체의 주소가 같은지?다른지
		System.out.println( strArray[0] == strArray[1]);
		System.out.println( strArray[0] == strArray[2]);
		
		//기준문자열.equals(비교문자열) : 구성문자열 비교
		//기준문자열.equalsIgnoreCase(비교문자열) :대소상관없이 비교
		System.out.println(strArray[0].equals(strArray[2]));
	} //main
}//end class
