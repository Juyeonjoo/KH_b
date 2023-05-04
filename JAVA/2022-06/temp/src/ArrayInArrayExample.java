import java.util.Arrays;

public class ArrayInArrayExample {

		//다차원 배열: 지금까지 우리가 다루었던 배열은 "1차원" 배열
		//	그런데 배열은 N원의 배열이 가능하다.
		public static void main(String[] args) {
			
			int[][] mathScores = new int[2][3]; 

			//카운터 변수 i는 1차원 배열의 인덱스 번호로 활용
				for(int i = 0 ; i < mathScores.length; i++) {
					//카운터 변수 k는 1차원배열의 원소의 인덱스 번호(2차원 배열)로 활용 
					for(int k = 0; k < mathScores[i].length; k++) {
						System.out.println("mathScores[" + i +"][" +k+ "]=" +mathScores[i][k]);
					} //Inner for
				} // Outer for
				System.out.println(Arrays.toString(mathScores));
				System.out.println(Arrays.toString(mathScores[0]));
				System.out.println(Arrays.toString(mathScores[1]));
		} //main
}//end class

