
public class ArrayCreateByNewExample {

	public static void main(String[] args) {
		
		int[] arr1 = new int[3]; // 배열의 기본값: 0
// ----------------------------------------------
		
		for(int i=0; i < 3; i++ ) {
			//배열의 원소에 접근하기 위해 인덱스번호를 사용하는 것을 "인덱싱(Indexing)"이라
			//부른다
			System.out.println("arr[" + i + "] : " + arr1[i]);
		}//for
// ----------------------------------------------
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		
		for(int i = 0; i < 3 ; i++) { // 인덱싱을 이용한 배열의 순회(traverse)
			
			System.out.println("arr1[" + i + "]" + arr1[i]);
		}//classical for
// ----------------------------------------------
		
		//새로운 배열 생성 (타입별 기본값으로 원소 채움)
		double[] arr2 = new double[3];
		
		for(int i =0; i<3; i++) {
			System.out.println("arr2]" + i + "] : " + arr2[i]);
		}
		//classical for
		
// ----------------------------------------------
		arr2[0] = 0.1;
		arr2[1] = 0.2;
		arr2[2] = 0.3;
		
		for(int i =0; i < 3 ; i++) {
			
			System.out.println("arr2]" + i + "] : " + arr2[i]);
		} // classical for
		
// ----------------------------------------------
		
		String[] arr3 = new String[3];
		
		for(int i=0; i<3; i++) {
			System.out.println("arr3[" + i + "]: " + arr3[i]);
		} // classical for
		
// ----------------------------------------------
		
		arr3[0] ="1월";
		arr3[1] ="2월";
		arr3[2] ="3월";
		
		for(int i=0; i<3; i++) {
			System.out.println("arr3[" + i + "]: " + arr3[i]);
			
		} // classical for
	} // main
} // end class
