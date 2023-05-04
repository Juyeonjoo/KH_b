package Nov24;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString

public class Product<T, M> { //부모 역할을 하는 제네릭 타입 클래스

	private T kind;
	private M model;

}//end class

//===============================

@ToString
@NoArgsConstructor
class Tv{
	;;
	} //end class