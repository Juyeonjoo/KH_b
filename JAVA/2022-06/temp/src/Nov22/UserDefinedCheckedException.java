package Nov22;


//사용자-정의 Checked Exception
public class UserDefinedCheckedException 
	extends Exception {

	public UserDefinedCheckedException() {
		super();
	}//default constructor
	
	public UserDefinedCheckedException(String message){
		super(message);
	}// constructor
	
} //end class
