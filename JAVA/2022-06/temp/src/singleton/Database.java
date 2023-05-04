package singleton;

public class Database {
	private static final Database CHECK_IP;

	String ipAddress;

	static {
		CHECK_IP = new Database();
	}//static

	private Database () {
		System.out.println("Database::default constructor invoked.");
		this.ipAddress = "66.249.69.76";
	}//Database

	static Database getInstance() {
		System.out.println("Database::getInstance() invoked.");
		return CHECK_IP;
	}//getInstance


	public static void main(String[] args) {

		Database database = Database.getInstance();
		System.out.println(database.ipAddress);


	}//main


}//Database

