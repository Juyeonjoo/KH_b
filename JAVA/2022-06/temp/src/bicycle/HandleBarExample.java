package bicycle;

public class HandleBarExample {
	public static void main(String[] args) {


		HandleBar handlebar= new HandleBar();
		handlebar.run(1);


		System.out.println("핸들 각도는 " +handlebar.direction +" 방향으로 "+ handlebar.degree + "도 입니다.");
		
		handlebar.broken();

	}
}
