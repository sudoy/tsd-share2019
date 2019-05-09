package yamamoto;

class GrFun{
	public <T> void func(T val) {
		System.out.println("val = " + val);
//		if(T.epuals() == Integer)
	}
}

public class Sample12_6 {

	public static void main(String[] args) {
		GrFun m = new GrFun();
		m.func(10);
		m.func(new Integer(10));
		m.func(10.0);
		m.func(new Double(10.0));
		m.func("田中");
	}

}
