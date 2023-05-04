
public class StudentExample {
	
	// 객체의 설계도인 클래스를 이용해서 객체를 생성해보자
	public static void main(String[] args) {

		// 첫 번째 학생 객체 생성 => new 클래스 생성자();
		Student s1 = new Student();
		System.out.println(s1); // 주소, 객체의 reference 참조

//		===
		//두 번째 학생 객체 생성 ==> new 클래스 생성자();
		Student s2 = new Student();
		System.out.println(s2);
		
	} // main

} // end class
