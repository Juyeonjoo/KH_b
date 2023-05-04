package Nov23;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Log4j2
//Generic 문법을 사용하기 전, 종이박스를 모델링한 클래스 선언
public class Box {
	
	private Object object;	//상자에 넣을 모든 종류의 객체를 저장할 필드


} //end class
