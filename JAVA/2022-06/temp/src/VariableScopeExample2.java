
public class VariableScopeExample2 {

	public static void main(String [] args) {
		
		int v1 = 15;
		
		if( v1 > 10 ) {
			
			int v2;
			
			v2 = v1 - 10;
			
		} //if 
		
		int v3 = v1 + v2 + 5; //v2 사용 불가, if 문에서 만들어졌기 때문
	}
}
