package Nov15;

//실체클래스 (Concrete class)
public class SmartPhone extends Phone {		//Phone은 추상클래스

	
	public SmartPhone(String owner) {
		super(owner);
		System.out.println("SmartPhone::constructor(owner) invoked.");
	}//SmartPhone(owner)
	
	public void internetSearch() {
		System.out.println("SmartPhone::internetSearch() invoked.");
	} //internetSearch() 
}//end class
