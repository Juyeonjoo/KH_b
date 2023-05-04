package Nov22;

public class MyCalculator<T> {
	
//	T : Type Parameter(실제 구체적인 타입(구체타입)을 받는 매개변수 역할)
	
	public boolean add(T obj1, T obj2) {
		return obj1 == obj2;
	}//add 
} //end class
	
//	//method overloading
//	public byte add(byte c, byte d) {
//		return (byte) (c+d);
//	}
//	
//	public short add(short e, short f) {
//		return (short)(e+f);
//	}
//	
//	public long add(long g, long h) {
//		return (long)(g+h);
//	}
//	
//	public float add(float i, float j) {
//		return (float)(i+j);
//	}
//	
//	public double add(double k, double l) {
//		return (double)(k+l);
//	}

