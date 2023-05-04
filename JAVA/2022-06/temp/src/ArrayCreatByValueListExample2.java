
public class ArrayCreatByValueListExample2 {
	//배열의 대전제: 자바의 배열은 한번 생성하면, 그 요소의 타입과 배열의 크기 변경 불가
	public static void main(String[] args) {
		
//		//1. 값의 목록으로 배열객체 생성
		int [] scores; //배열선언
		scores = new int [] { 83, 90, 87 }; //초기화, new 연산자 필요? 선언과 초기화를 구분했을 분
		//int[] scores = {83, 90, 87}; 와 다름?
////		scores = {83, 90, 87};  // 이렇게는 안된다.
//		
		System.out.println("scores : " + scores); //scores : [I@5ca881b5

		
//		===================
		//2. 배열의 순회(traverse)를 이용한, 배열의 모든 원소의 총합을 구하자
		int sum1 = 0;
		
		for(int i = 0; i < 3; i++) {
			
			sum1 += scores[i];
		} //for
		
		System.out.println("총합 : " + sum1);
//		===================
//		
		int sum2 = add ( new int [] { 83,90, 87 }); // 메소드 호출할 때 int type의 배열 달라.(배열 객체 넘겨주는 것)
//		int sum2 = add({ 83,90, 87 })// add 호출할 때, 배열 literal,(배열 객체 직접 만든다) 배열 객체를 전달해야한다.
									//배열 변수의 초기화가 분리되면, new 써야 하고 배열 생성자 지정해야 한다. 
		System.out.println("총합 : " + sum2);
		System.out.println();
	}//main
	
	//배열 객체를 받아서 배열을 순회학며 배열 원소의 총합을 구해주는 메소드
	// 메소드: 객체의 행위(=기능), 예: 사람 - 걷다/ 뛰다/자다 등등의 행위
	
		public static int add(int [] scores) { //배열을 받아야 한다.
			
			int sum = 0;
			for(int i = 0; i < 3; i++) {
				sum += scores[i];
			}
			return sum;
		}// add
} //end class
