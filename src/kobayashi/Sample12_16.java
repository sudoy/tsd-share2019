package kobayashi;

public class Sample12_16 {

	public static void main(String[] args) {
		func(10);
	}
	//暗黙の変換
	static void func(long i) {System.out.println("(long i)");}
	//autoboxing
	static void func(Integer i){System.out.println("(Integer i)");}
	//可変長引数
	static void func(int...i){System.out.println("(int...i)");}

}
