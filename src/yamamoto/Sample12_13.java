package yamamoto;

public class Sample12_13 {
	static Integer wi1;

	public static void main(String[] args) {
		Integer wi2 = 199;
		wi2++;
		Integer wi3 = 200;
		if(wi2 ==wi3) {
			System.out.println("Atea: " + areaOfSquate(4.0));
		}
	}
	public static Double areaOfSquate(Double side) {
		return side * side;
	}

}
