package yamamoto;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaExpression2 {

	public static void main(String[] args) {
		String[] array = {"abc", "abcdefg", "a", "ab", "cdef"};
		Comparator<String> s1 = new Arraysort();
		Arrays.sort(array, s1);
		System.out.println(Arrays.toString(array));

		Comparator<String> s2 = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() <= o2.length() ? -1 : 1;
			}
		};
		Arrays.sort(array, s2);
		System.out.println(Arrays.toString(array));

		Comparator<String> s3 = (String o1, String o2) ->{
			return o1.length() <= o2.length() ? -1 : 1;
		};
		Arrays.sort(array, s3);
		System.out.println(Arrays.toString(array));

		Comparator<String> s4 = (String o1, String o2) ->o1.length() <= o2.length() ? -1 : 1;
		Arrays.sort(array, s4);
		System.out.println(Arrays.toString(array));
	}

}

class Arraysort implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		return o1.length() <= o2.length() ? -1 : 1;
	}
}
