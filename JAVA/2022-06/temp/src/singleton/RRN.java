package singleton;

public class RRN {

	private static final RRN CHECKNUMBER;

	String 홍길동;

	static {
		CHECKNUMBER = new RRN();
	}//static

	private RRN () {
		System.out.println("RRN::default constructor invoked.");
		this.홍길동 = "123456-654321";
	}//RRN

	static RRN getInstance() {
		System.out.println("RRN::getInstance() invoked.");
		return CHECKNUMBER;
	}//getInstance


	public static void main(String[] args) {

		RRN rrn = RRN.getInstance();
		System.out.println(rrn.홍길동);


	}//main


}//RRN

