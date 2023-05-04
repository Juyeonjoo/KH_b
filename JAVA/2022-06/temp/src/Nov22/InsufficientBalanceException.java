package Nov22;

public class InsufficientBalanceException 
	extends RuntimeException {

	public InsufficientBalanceException() {
		super();
	}//default constructor
	//오류메시지 없이도 
	
	public InsufficientBalanceException(String message){
		super(message);
	}// constructor
	//오류의 원인 알려주고 싶을 때 
	
} //end class
