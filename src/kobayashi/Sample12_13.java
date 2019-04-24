package kobayashi;

public class Sample12_13 {

	static Integer wi1;

	public static void main(String[] args) {

		//wi++;//実行時エラー//nullに足し算をしていることになる
		Integer wi2 =199;//Autoboxing
		wi2++;//演算可能//unboxingでint、インクリメントした後にboxingでIntegerに
		Integer wi3 = 200;
		if (wi2 == wi3) {
			System.out.println("Area :" + areaOfSquare(4.0));
		}
	}

	public static Double areaOfSquare(Double side) {
		return side * side;//演算可能
	}
}
