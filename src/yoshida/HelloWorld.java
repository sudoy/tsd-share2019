package yoshida;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");

		Sample[]array = {new Sample (10),new Sample (20)};
		Sample[]array2 = new Sample[2];
		System.arraycopy(array, 0, array2, 0, 1);
		array2[1].num = 100 ;
		System.out.println(array[1].num);
		System.out.println(array2[1].num);
	}
}
class Sample{
	int num ;
	Sample(int num){
		this.num = num ;
	}
}