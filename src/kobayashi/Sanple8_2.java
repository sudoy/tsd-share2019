package kobayashi;

public class Sanple8_2 {

	public static void main(String[] args) {
		String ext = "From external class";
		MyTopLevelS.gateToStatic();
		MyTopLevelS.StaticNested sn =
				new MyTopLevelS.StaticNested();
		sn.accessStaticNested(ext);

	}

}
class MyTopLevelS{
	private static String top = "From top level class";
	public static void gateToStatic() {
		StaticNested s = new StaticNested();
		s.accessStaticNested(top);
	}
	static class StaticNested{
		public void accessStaticNested(String st) {
			System.out.println(st);
		}
	}
}

