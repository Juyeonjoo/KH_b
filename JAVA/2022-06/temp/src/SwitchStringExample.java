
public class SwitchStringExample {
//	switch 문에 비교타입으로, int/char/String 가능
	public static void main(String[] args) {
		
		String position = """
				과장님
				"""; //text block
				
		
		switch(position) {
			case """
					부장님
					""":
				System.out.println("700만원");
				break;
			case """
					과장님
					""":
				System.out.println("500만원");
				break;
			default:
				System.out.println("300만원");
		
		} //switch
	} //main
}//end class
