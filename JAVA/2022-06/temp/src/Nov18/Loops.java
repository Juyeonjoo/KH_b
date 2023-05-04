package Nov18;


/* a = 5, b= 3, n=5
 * 5 + 1*3 = 8
 * 5 + 1*3 + 2*3 = 14 (앞 결과인 8 + 2*3을 더한  값)
 * 5 + 1*3 + 2*3 + 4*3 = 26(앞 결과에 4*3을 더한 값)
 * 5 + 1*3 + 2*3 + 4*3 + 8*3 = 50 (앞 결과에 8*3을 더한 값)
 * >> 더한 값은 2*3, 4*3, 8*3으로 b에 2를 곱한 값 만큼 커진다.
 */


import java.util.Scanner;

public class Loops {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int num = in.nextInt();

		for(int i=0; i<num; i++){
			int a = in.nextInt();
			int b = in.nextInt();
			int n = in.nextInt();

			for(int j = 0; j < n; j++) {
				a += b;

				if(j > 0 ) {
					System.out.print(" ");				//한줄띄우지 말라고 했기 때문에 print
				}
				System.out.print(a);
				b= b*2;
			} //for

			System.out.println();

		} // for
		in.close(); 	//scanner 종료

	} //main
} //Loops class