import java.util.Arrays;

public class ArrayCopyByForExample {
	/* 핵심: 기존 배열을 새로운 배열로 복제(copy)
	 * 복제방법 2가지 (1) Deep Copy(완전히 새로운 객체로 만들어 복제)
	 *				(2)	Thin(=Shallow copy) copy(주소만 복제)
	 */
	
	
	public static void main(String[] args) {
		
		int[] oldIntArray = {1,2,3}; // 1-D Array
		int[] newIntArray = new int[5];//*NEW* 1-D Array without values.
		
		for(int i = 0 ; i < oldIntArray.length; i++) { //기존 배열의 순회
			newIntArray[i] = oldIntArray[i];	// 새로운 배열의 원소로 복사(copy)
		} //Classical For
		
//		---------------------------
//		//아래 배열 순회 및 원소 출력 코드는 쓸데 없음
//		
//		for(int i =0; i < newIntArray.length; i++) { //새로운 배열의 순회
//			
//			System.out.println(newIntArray[i]+ ", " ); //배열원소의 출력
//		}//Classical For
		//위 출력 코드는 아래의 1문장으로 더 좋은 출력결과 생성
		System.out.println(Arrays.toString(newIntArray));
	}//main
}//end class
//[1, 2, 3, 0, 0]