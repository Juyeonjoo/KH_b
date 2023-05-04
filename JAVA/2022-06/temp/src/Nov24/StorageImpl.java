package Nov24;

import lombok.ToString;

@ToString
//제네릭 인터페이스를 구현(implements)하는 자식 제네릭 타입의 구현 클래스
public class StorageImpl<T> implements Storage<T> {

	private T[] array;
	
	@SuppressWarnings("unchecked")
	public StorageImpl(int capacity) {
		this.array = (T[])(new Object[capacity]);
	} //constructor
	
	
	@Override
	public void add(T item, int index) {
		array[index] = item;
	} //add

	@Override
	public T get(int index) {
		
		return array[index];
	}//get

} //end class
