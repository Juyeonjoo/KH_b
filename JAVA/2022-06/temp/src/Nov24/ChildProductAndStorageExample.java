package Nov24;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ChildProductAndStorageExample {

	public static void main(String[] args) {
		
		//1.제네릭 타입의 자식 클래스로부터 인스턴스 생성
		ChildProduct<Tv, String, String> product = new ChildProduct<>();
		
		product.setKind(new Tv());
		product.setModel("smartTv");
		product.setCompany("Samsung");
		
		log.info(product);

//		===================================
		
		//2. 제네릭 타입의 구현 클래스로부터 인스턴스 생성
		
		//Lvalue 변수 타입 자체가 인터페이스 
		Storage<Tv> storage = new StorageImpl<>(100);	//다형성1
		
		storage.add(new Tv(), 0);		//다형성2
		Tv tv = storage.get(0);			//다형성2
		log.info(storage);
	} //main
}//end class
