package suzuki;

public class Sample8_1 {

	public static void main(String[] args) {

		String ext = "From external class";

		MyTopLevel mt = new MyTopLevel();
		mt.createNested();

		MyTopLevel.MyInner inner = mt.new MyInner();
		inner.accessInner(ext);
	}

}

class MyTopLevel{ //外部クラス

	private String top = "From Top level class";
	MyInner minn = new MyInner();

	public void createNested() {
		minn.accessInner(top);
	}

	class MyInner{ //ネストクラス（インスタンス）

		public void accessInner(String st) {
			System.out.println(st);
		}
	}

}

