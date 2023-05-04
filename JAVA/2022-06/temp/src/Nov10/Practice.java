package Nov10;

public class Practice {

	
	public class Singleton {

		private static final Singleton MY_SELF_ADDRESS;

		
		public int[] passwords;
		
		public Singleton() {
			System.out.println("Singleton::default constructor invoked.");
			
			this.passwords = new int[] {1,2,3,4,5};
		} //  default constructor ,외부에서 사용하지 못하도록 private
		
		public static void main(String[] args) {
			Singleton();
		}
	}//end class, 
	
}
