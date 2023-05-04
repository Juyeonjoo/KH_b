
public class ForMultiplicationTableExample {

	public static void main(String[] args) {
		
		for (int 단수 = 2 ; 단수 <= 9; 단수++) { // 구구단에서 단수를 증가시키는 역할
			System.out.println("*** " + 단수 + "단 ***");
			
			for (int 곱하는수 = 1; 곱하는수 <=9; 곱하는수++) { // 
				System.out.println(단수 + " x " + 곱하는수 + " = " +(단수*곱하는수));
			} //for: 중첩된 안쪽 반복문 
			
		} // for: 바깥쪽 반복문 
	} //main
} //end class
