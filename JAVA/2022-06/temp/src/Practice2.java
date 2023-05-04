
public class Practice2 {

	public static void main(String[] args) {
		
		
		int intValue = 4 ;

		int result2 = switch(intValue) {

			case 4 -> {
										//연산식을 통해, 값을 생성하려면, yield 키워드로 생성
				yield 4 * 4 ;			//4의 2승(지수승 계산)
			}
			//1개 밖에 없는 값을 생성하는 실행문장 안에 yield 키워드가 있다면, 
			// {} 중괄호 기호를 생성할 때, yield 키워드까지 생략해야만 한다. 
			case 3 -> 3 * 3;
			
			case 5 -> 1000;
			
			case 6 -> intValue;

			
		
		default -> { // switch expression이 값을 생성하는 Rvalue역할을 한다면
			//	생략 불가
			//연산식을 통해 값을 생성하려면 yeild 키워드로 생성
			yield intValue * intValue;
			
		} // switch expression

		};
		System.out.println(result2);
		
		
	}
}
