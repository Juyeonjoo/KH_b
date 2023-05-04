
public class BreakOutterExample {

	public static void main(String[] args) {
		
		Outter:  //label붙임(바깥쪽 반복문에)
			for(char upper = 'A'; upper<='Z'; upper++) { //'A' ~ 'Z'까지 반복
			
			for(char lower ='a'; lower <= 'z'; lower++) {//'a' ~'z'까지 반복
				System.out.println(upper + "-" + lower);
				
				if(lower == 'g') { // 소문자 'g'일때 안쪽/바깥쪽 반복 깨트림
					break Outter; //label과 함께 사용  
					
				} //if
				
			}// 안쪽 for
		}//바깥쪽 for
		
	}  //main
} // end class

/*
A-a
A-b
A-c
A-d
A-e
A-f
A-g
*/
