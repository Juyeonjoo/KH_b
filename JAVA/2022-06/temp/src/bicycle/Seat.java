package bicycle;

public class Seat {
   
   
   //고유 속성 필드
   //===============================================
   
   
   String brand;      //브랜드
   String model;      //모델
   String color;      //색상
   String material;   //재료 [가죽,충전재,철제]
   double weight;      //무게
   int price;      //가격
   
   
   //상태 필드
   //================================================
       
   
   boolean hold = true; //안장이 고정되어 있는 상태
   int height = 0;
  

	boolean isBroken;
   
   //메소드 필드
   
   void hold () {
	   if(this.hold == true) { 
		   System.out.println("이미 안장이 고정되어 있습니다.");
		   
	   } else  { //안장이 고정되어있지 않다면,
			   System.out.println("안장을 고정합니다.");
		       this.hold = true;} 
	
   }// hold 안장 고정 메소드 
   
   void unhold () {
	   if(this.hold == false ) {  //안장이 고정되어있지 않다면,
		   System.out.println("이미 안장이 풀려 있습니다.");
		          
	   }  else {								   
		       System.out.println("안장을 풉니다.");
		       this.hold = false;}//if - else
   }// hold 안장 해제 메소드 
 
   
   
	
   void setting (int i) {
	   if(0 < i && i < 5) { // 1~4사이의 높이로 안장을 세팅
		   if(this.hold == true ) {
		   System.out.println("안장을 풉니다.");
		   this.hold = false; }
		   
		   System.out.println("안장을 i높이에 맞춥니다.");
		   this.height = i;
		   
		   System.out.println("안장을 고정합니다.");
		   this.hold = true; 
	   
	   } else {            //안장의 높이가 맞지 않다면 안정의 높이가 맞지 않다고 출력
		   System.out.println("높이가 맞지 않습니다.");
		   
	}//if-else
	   
}//setting메소드
   
   void broken() {
	   if(isBroken) {
		   System.out.println("안장이 고장났습니다. 높이가 1이 됩니다.");
		   this.height = 1;
	   } else {
		   System.out.println("안장이 정상 작동 합니다.");
	   } //if-else

	}//broken

   //생성자
   //================================================
   
   
   public Seat(){}//기본 생성자
   
   
   public Seat(int price) {
      this(null, null, null, null, 0.0, price);
      
   }//가격 입력 생성자
   
   
   public Seat(String brand,String model, String color, String material,double weight, int price) {
      this(brand, model, color, material, weight, price, false);
      
   }//고유 속성 생성자
   
   
   public Seat (boolean hold) {
      this(null, null, null, null, 0.0, 0, hold);
      
   }//안장 on/off 생성자
   
   
   public Seat(String brand,String model, String color, String material,
       double weight, int price, boolean hold) {
      
      this.brand = brand;         //브랜드
      this.model = model;         //모델
      this.color = color;         //색상
      this.material = material;   //재료
      this.weight = weight;      //무게
      this.price = price;         //가격
      this.hold = hold;         //안장 고정 on/off
      
   }//전체 생성자
   
   
   
   //===================================================
   
   
}//class