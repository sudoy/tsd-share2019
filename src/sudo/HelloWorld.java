package sudo;

public class HelloWorld {

	public static void main(String[] args) {
		String s = null;
		s.equals("sss");

		Test t = new Test();
		t.name = "hogehoge";
		t.method();
	}

}


class Test{
	String name;

	void method() {
		System.out.println(name.equals("aaa"));
	}
}