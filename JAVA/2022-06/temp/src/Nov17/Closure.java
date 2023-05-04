package Nov17;

import java.util.Arrays;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class Closure {
	private static MyInterface anonymouseObj; //필드
	
	public static void main(String[] args) {
		log.trace("main([]) invoked.", Arrays.toString(args));
		
		Closure obj = new Closure();
		obj.run("Yoseph");
		//The local variables : name, age, in the run() method destroyed.
		anonymouseObj.instanceMethod();//다형성2
		anonymouseObj.instanceMethod();//다형성2
	}//main
	
	public void run(String name) {	//매개변수1: 지역변수1로 간주함
		log.trace("run() invoked.", name);
		
		int age = 23;		//지역변수 정의
		age = 18;			// 상수화되었기 때문에 고칠 수 없다.
		name = "Ju";
		
		double weight = 58.9; //지역변수3 정의
		
		//대전제: 지역변수의 유효범위(생명주기)는, 		
		//자신이 선언된 중괄호블록이 끝나면 파괴된다.
		
//		=====================================
//		MyInterface에 대한 익명구현객체 생성
//		=====================================
		anonymouseObj = new MyInterface() {		//다형성1

			@Override
			public void instanceMethod() {
		log.trace("MyInterface() invoked.");
				
		//과연 익명구현객체 내부에서 this는 무엇을 의미?
		//우리가 아는 그 this? 같다.
		log.info("\t+ this: {}", this);
		
//		--------------------------------------
//		익명구현객체 코딩이 들어간 메소드 내의 지역 변수 사용
		log.info("\t + name: {} , age: {}", name, age);
		
			} //instanceMethod
		}; //익명구현객체
		log.info("+ anonymouseObj: {}", anonymouseObj); //참조변수의 레퍼런스 출력

	}//run()
}//end class
