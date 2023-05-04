
public class CharExample {

	public static void main(String[] args) {
		
		char c1 = 'A'; // 1. 문자를 직접 저장
		char c2 = 65; // 2. 십진수로 저장
		char c3 = '\u0041'; //3. Unicode 값으로 저장
		
		char c4 = '가'; // 1. 문자를 직접 저장
		char c5 = 44032; // 2. 십진수로 저장
		char c6 = '\uac00'; //3. Unicode 값으로 저장
		
		// Lvalue(4,int) = Ravalue(char, 2) => 자동형변환
		int uniCode =c1; //Unicode 얻기
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(uniCode);

	}
}
//
//A
//A
//A
//가
//가
//가
//65
