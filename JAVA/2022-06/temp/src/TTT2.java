
public class TTT2 {

	
	{
		System.out.println("1"); // 값 안나옴
	} // User-defined block 사용자 정의 블록, 실행문 만들 수 있음.
	
	public static void main(String [] args ) {
		
		{
			System.out.println("2");
		}
		
			{	
				{System.out.println("3");}
			}

		
	} //main
	
	{System.out.println("4");}
	
} // end class

// 2, 3 만 출력