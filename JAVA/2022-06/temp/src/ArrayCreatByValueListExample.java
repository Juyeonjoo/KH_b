
public class ArrayCreatByValueListExample {

	public static void main(String[] args) {
		
		//1. 값의 목록을 가지고, 배열 객체 생성 :이때는 중괄호 기호 [] 사용
		int[] scores = {83, 90, 87}; // 배열 literal, length 3 (배열의 크기/길이)
		
		//2. 특정 배열 원소(=요소)에 접근하여 사용, 인덱스 번호로 접근
		System.out.println("scores[0]: " + scores[0] ); //배열의 인덱스 0부터 시작
		System.out.println("scores[1]: " + scores[1] );
		System.out.println("scores[2]: " + scores[2] );

		//3. 배열의 순회(Traverse) - 하나씩 차례대로 
		int sum =0;
		
		for(int index = 0; index < scores.length ; index ++) {
			sum += scores[index];			//복합 대입연산자 : +=	
		}//for
		
		//4. 배열에 있는 데이터를 이용하여 새로운 정보 생성
		System.out.println("총합 : " + sum);
		double avg = (double) sum / 3;	////정수연산식의 결과는 정수로 나오기 때문에 double
		//강제형변환 (double), 이항연산자보다 우선
//		double avg = (double) (sum/3); // 평균 86.0
		System.out.println("평균 " + avg);
		
		
	}//main
}//end class
