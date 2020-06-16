package stuff;

public class MyClassA {
	public static void main (String args []) {
		MyClassC m = new MyClassC (23, true);
	} // end main
}

class MyClassC {
	int v = 12;
	
	private MyClassC (int pV) {
		int v = pV;
   } 
	
	public MyClassC (int x, boolean b) {
		this(x);
		System.out.println(x);
	}
}
