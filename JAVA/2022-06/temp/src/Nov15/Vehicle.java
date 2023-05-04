package Nov15;

//POJO: Plain Old Java Object
public class Vehicle { // 모든 자동차를 대표하는 클래스 => 부모 클래스가 됨
 
	
	
	//그 어떤 종류의 자동차라고 해도 적어도 아래의 공통 기능은 있어야 함
	public void run() {
		System.out.println("Vehicle::run() invoked");
		System.out.println("차량이 달립니다.");	//기분구현만 해 놓음
	} //run()
}//end class
