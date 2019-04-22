package sudo;

public class TryCatchPractice {

	public static void main(String[] args) {
		String[] a1 = {"5", "23", "123", "89", "91", "23"};
		int[] array = makeArray1(a1);

		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static int[] makeArray1(String[] a) {
		int[] array = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			int x = Integer.parseInt(a[i]);
			array[i] = x;
		}
		return array;
	}
}