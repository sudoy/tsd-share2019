package fujinoki;

public class Sample12_13 {

	public static void main(String[] args) {
		Integer wi2 = 199;//auto boxing
		wi2++;
		Integer wi3 = 200;

		if (wi2 == wi3) {
			System.out.println("Area:" + areaOfSquare(4.0));

		}

	}

	public static Double areaOfSquare(double side) {
		return side * side;

	}

}
