package fujinoki;
class Bar<T>{
	private T val;
	public Bar(T val) {
		this.val = val;
}

	public T getVal() { return val;}

	public void setVal(T val) {this.val = val;}
}
public class Sample12_5 {

	public static void main(String[] args) {
		Bar<String>obj1 = new Bar<String>("a");
		System.out.print(obj1.getVal());
		obj1.setVal("b");
		System.out.println(" " + obj1.getVal());
		
		Bar<Integer>obj2 = new Bar<Integer>(1);
		System.out.print(obj2.getVal());
		obj2.setVal(2);
		System.out.println(" " + obj2.getVal());

	}

}
