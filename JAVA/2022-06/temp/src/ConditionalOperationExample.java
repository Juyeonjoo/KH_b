
public class ConditionalOperationExample {

	//삼항연산자 : 연산식에서 피연산자가 3개인 연산자
	//문법 : (조건식) ? 값1 : 값2;
	public static void main(String[] args){
		
		int score =85; //조건식
		char	A_grade = 'A';
		char 	B_grade = 'B';
		char 	C_grade = 'C';
		
		char grade = (score> 90) ? A_grade : (score>80) ? 'B' : 'C';
//				(score > 90) ? //조건식
//				A_grade : //조건식이 true일 때, 반환값
//					((score > 80) ? 'B' : 'C'); //조건식이 false일때 반환값 
		
		System.out.println(score + "점은 " + grade + "등급입니다.");
		
//		=== Text Block (JAVA 15LTS : 표준문법채택) ===
		
		String multiLine = """
				행1
					행2
				                                    행3	
				""";

		String multiline2 = """
				empty
				""";
		String multiLine3 = """
				""";
		String multiline4 = """
				empty
				""";
		System.out.println(); // 아무것도 출력하지 않으면 = > 빈행을 출력
		System.out.println(multiLine);
		System.out.println(multiline2);
		System.out.println(multiLine3);
		System.out.println(multiline4);
	} //main
} //end class
