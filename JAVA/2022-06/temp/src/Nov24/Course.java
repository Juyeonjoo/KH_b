package Nov24;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@ToString

//타입 파라미터를 1개 가지는 제네릭타입 클래스
//목적: 수강 신청 가능한 과정을 모델링한 클래스
public class Course<T> {

@Getter private String name;
@Getter private T[] students;
	
	@SuppressWarnings("unchecked")
	public Course(String name, int capacity) {
		log.trace("constructor({}, {}) invoked.", name, capacity);
		
		//인스턴스필드 초기화
		this.name = name;
		
		//배열 객체 생성시, 원소의 타입은 제네릭의 타입 파라미터로 지정 불가
//		this.students = new T[capacity];
		//어떻게 T 타입을 원소로 가지는 배열객체를 생성할 수 있을까?
		//(1) Object[] 배열 우선 생성
		//(2) Object[] 배열 => T[] 배열로 강제 형변환 해야 함
		students = (T[])(new Object[capacity]); 	//***주의***/
	}//constructor
	
	//과정에 수강신청한 학생을 배열의 원소로 넣어주는 메소드
	//대전제: 자바으 ㅣ배열은 한번 생성하면 그 크기(길이)와 원소의 타입 변경 불가
	public void add(T t) {
		log.trace("add({} invoked.)", t);
		
		for(int i = 0; i <students.length; i++) {
			if(students[i] ==null) {		//null을 값으로 가지는 배열의 원소에다가 학생 추가 
				students[i] = t;
				
				break;				//for문 빠져나옴
			}//if
		}//for
	}//add
	
}//end class

