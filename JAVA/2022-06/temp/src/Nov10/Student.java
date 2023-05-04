package Nov10;

public class Student //student클래스가 people 클래스를 extends 받습니다.
	extends People{

	public int studentNo;
	
	public Student(String name, String ssn, int studentNo) {
		super(name, ssn);
		this.studentNo = studentNo;
	}//Constructor
} //end class
