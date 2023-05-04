package Nov24;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString

//제네릭 타이브이 클래스를 상속하는 자식 제네릭 타입의 클래스 선언
public class ChildProduct<T, M, C> extends Product <T, M>{

	private C company;
	
	
} //end class
