
public class ArrayLengthExample {
	
	//배열을 순회할 때 ,배열의 길이(=크기)를 이용해서, 반복횟수를 제한하는게 골자
	public static void main(String[] args) {
		int[] scores = { 83, 90, 97}; 			//값의 목록으로 배열 리터럴 생성
		int[] scores2 = new int[] { 83, 90, 97}; // Ditto. But, Above statement preferred.
//		int[] scores3 = new int[3] { 83, 90, 97};// xx: 배열의 크기는 값의 목록으로 자동결정 	
		int sum = 0;
		for(int i =0 ; i < scores.length; i++) { // 배열변수명.length => 배열의 크기(=길이)
			sum+= scores[i];
		} //for
		
		System.out.println("총합: " +sum);
		
		double avg = (double) sum / scores.length;
		System.out.println("평균 : " + avg);

	} // main
} // end class 
