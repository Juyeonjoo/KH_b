package Nov15;

public class TTT {

	//대전제: 모든 참조타입객체의 조상 타입 --->Object
	public static void main(String[] args) {
		
		Object obj = "Yoseph";		//다형성1
		
//		if(obj instanceof String) {	//@until Java8
//			String s = (String) obj; // 강제형변환이 무조건 필요
//			System.out.println(s);
//		}//if
//		
		if(obj instanceof String s) {	//강제형변환 필요 없음.
			System.out.println(s);
		}//if
	}//main
		
	}//end class
