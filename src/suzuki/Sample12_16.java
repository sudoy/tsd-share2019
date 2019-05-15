package suzuki;

public class Sample12_16 {

	public static void main(String[] args) {

		func(10);
	}

	static void func(long i) {System.out.println("(long i)");}

	static void func(Integer i){System.out.println("(Ineger i)");}

	static void func(int... i){System.out.println("(int... i)");}
}
