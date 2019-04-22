package suzuki;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaExpression3 {

	public static void main(String[] args) {

		String[] array = {"abc", "abcdefg", "a", "ab", "cdef"};

//		Arrays.sort(array, new Sort2());
//		System.out.println(Arrays.toString(array));

		Comparator<String> c1 = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() > o2.length() ? 1 : -1;
			}
		};

//		Arrays.sort(array, c1);
//		System.out.println(Arrays.toString(array));

		Comparator<String> c2 = (String o1, String o2) ->{
			return o1.length() > o2.length() ? 1 : -1;
		};

//		Arrays.sort(array, c2);
//		System.out.println(Arrays.toString(array));

		Comparator<String> c3 = (o1, o2) -> o1.length() > o2.length() ? 1 : -1;

		Arrays.sort(array, c3);
		System.out.println(Arrays.toString(array));

	}

}

class Sort2 implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		return o1.length() > o2.length() ? 1 : -1;
	}
}