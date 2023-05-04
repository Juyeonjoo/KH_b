package Nov15;


//자식객체에게 다형성과 관련된 규격의 강제성을 가지게 한다.
public abstract class Animal {

	public String kind;

	
	public Animal() {
		System.out.println("Animall::default constructor invoked.");
	}//default constructor
	
	public void breath() {
		System.out.println("Animal::breath() invoked.");
	}// breath()
	
//	(1) 메소드의 구현부(중괄호 블록)이 없는 메소드 => "추상메소드"
//	(2) 추상메소드는 반드시 메소드 시그니처에 "abstract" 키워드 붙여야 함
	public abstract void sound(); //추상메소드(abstract method)
	//구현부가 없어서 호출로그를 넣을 수 없다.
} // end class
