
public class IncreaseDecreaseOperatorExample {

	//증감 연산자: 단항, 변수의 값을 1 증가시키거나, 1 감소시킨다.
	//증감 연산자의 구분: (1) 전위 (2) 후위
	// (주의)  (1) 전위와 (2)후위에 따라 증감연산자의 연산이 

	public static void main(String[] args) {
		
		int x = 10;
		int y = 10;
		int z;
//		============================
		System.out.println("--------------------------");	
		
		x++; // 증가 연산자 => '후위'
//		x = x+1; 
		++x; // 증가 연산자 => '전위' //x=12
		
		System.out.println("x= "+ x);
		
//		============================
		System.out.println("--------------------------");		
		//감소연산자
		y--; //감소연산자 => '후위'
		y = y-1;
		--y; //감소연산자 => '전위' // -7

		System.out.println("y= " + y);
		
//		============================		
		//전위와 후위의 차이점
		System.out.println("--------------------------");

		// (1) '전위' 증감연산자: 증감연산부터 수행>수행결과를 연산식에 적용
		// (2) '후위' 증감연산자: 연산식부터 수행 > 증감연산자를 수행
		z = x ++; // 후위: 대입연산자에 먼저 넣고 증감 동작 나중에 
		//x변수 증감시키기 전에 z 에 넣어버림. 그 이후에 x 의 값 증가
		//후위일 경우 
//		z= x;
//		x = x+1;
		System.out.println("z = " + z); //z = 12
		System.out.println("x = " + x); //x = 13
		
//		============================	
		System.out.println("--------------------------");
		z = ++x; //'전위' 증가연산자
		
//		x=x+1;
//		z=x;
		
		System.out.println("z= " + z); // 14
		System.out.println("x =" +x);// 14
		
//		============================	
		System.out.println("--------------------------");
		
//		z= ++x + y ++;
//		
		x= x + 1;
		z = x + y;
		y = y + 1;
		
		System.out.println("z= " + z); //z= 22
		System.out.println("x= " + x); //x = 15
		System.out.println("y= " + y); // y=8

	
		
	}//main
}//end class
