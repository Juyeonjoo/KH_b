
public class PersonExample {

	//final 필드
	public static void main(String[] args) {
		Person p1 = new Person("123456-1234567", "계백");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
//		p1.nation = "usa";		//nation을 바꾸려고 하니?
//		p1.ssn = "654321 - 7654321";
		p1.name = "을지문덕";		// 값 바꾸는거 허용
	} //main
} // end class
