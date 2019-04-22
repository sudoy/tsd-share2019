package yamamoto;

public class Sample8_1 {

	public static void main(String[] args) {
		String ext = "From external class";
		MyTopLevel mt = new MyTopLevel();
		mt.createNested();
		MyTopLevel.MyInner inner = mt.new MyInner();
		inner.accessInner(ext);
	}

}
class MyTopLevel{
	private String top = "From Top level class";
	MyInner minn = new MyInner();

	public void createNested() {
		minn.accessInner(top);
	}

	class MyInner{
		public void accessInner(String st) {
			System.out.println(st);
		}
	}
}