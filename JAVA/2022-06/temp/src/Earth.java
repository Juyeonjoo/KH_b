
public class Earth {

	// 이 예제를 통해서, 그냥 final 필드와 static final 필드의 차이점을 이해하자
	// 대전제: 모든 객체에 불변의 진리값을 만들고자 할 때에는 static final 상수로
	// 각 객체에서만 상수를 만들고자 할 때는 그냥 final 상수로
	
	//불변의 진리값으로 지구의 반지름을 static final 필드로 선언
	static final double EARTH_RADIUS  ;	
	static final double EARTH_SURFACE_AREA;		//그럼 지구의 면적은?
	
	
	static {
		
		/*static initializer 주의사항
		 * (1) final 이 붙지 않은 static 필드를 static initializer 에서 초기화할 때에는, 정적멤버답게
			클래스명.static 필드명 = 초기값 허용

		(2) final 이 붙은 static 필드를 static initializer에서 초기화할 때에는
			오히려 클래스명을 제거하고 필드명만으로 초기화 해줘야 한다.
		 * 
		 */
		EARTH_RADIUS	= 6400;		//oo 6400km EARTH_RADIUS.
//		Earth.EARTH_RADIUS	= 6400;		//xx 
		
		//지구의 면적을 공식을 통해서 구한값으로 sattic final 필드의 초기화
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS *EARTH_RADIUS;

	} // static initializer (static 멤버의 초기화)
			//final과는 무관, static가 있으니까
} //end class
