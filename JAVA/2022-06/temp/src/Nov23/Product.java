package Nov23;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor(access=lombok.AccessLevel.PUBLIC)
@Getter(lombok.AccessLevel.PUBLIC)
@Setter(lombok.AccessLevel.PUBLIC)
//멀티 타입 파라미터 사용법
//즉, 타입 파라미터가 1개 이상인 경우
// 그저, 타입 파라미터 개수/순서/의미에 맞게, "구체타입"을 
// 지정하면 된다.(제네릭 타입을 '사용'할 때)
public class Product<T, M> {

	private T kind;
	private M model;
}//end class

//	public T getKind() {
//		return this.kind;
//	}//getKind()
//	
//	public M getModel() {
//		return this.model;
//	}//getModel
//	
//	public void setKind(T kind) {
//		this.kind = kind;
//	}//setKind
//	
//	public void setModel(M model) {
//		this.model = model;
//	}//setModel

