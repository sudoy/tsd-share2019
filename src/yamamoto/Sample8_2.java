package yamamoto;

public class Sample8_2 {

	public static void main(String[] args) {
		String ext = "From external class";
		MyTopLevelS.gateToStatc();
		MyTopLevelS.StaticNested sn = new MyTopLevelS.StaticNested();
		sn.accessStaticNested(ext);
	}

}
class MyTopLevelS{
	private static String top = "From Top level class";
	public static void gateToStatc() {
		StaticNested s = new StaticNested();
		s.accessStaticNested(top);
	}

	static class StaticNested {
		public void accessStaticNested(String st) {
			System.out.println(st);
		}
		
	}
}