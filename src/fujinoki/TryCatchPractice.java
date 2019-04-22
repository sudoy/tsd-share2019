package fujinoki;

public class TryCatchPractice {

	public static void main(String[] args) {
		//String[] a1 = {"5", "23", "123", "89", "91", "23"};
		String[] a1 = {"5", "23", "a", "89", "b", "c"};
		int [] array = makeArray4(a1);
		for(int i = 0;i < array.length;i++) {
			System.out.println(array[i]);
		}
	}

	private static int[] makeArray1(String[] a) {
		int[] array = new int[a.length];
		for(int i = 0;i < array.length;i++) {
			int x = Integer.parseInt(a[i]);
		}

		return array;
	}

	private static int[] makeArray3(String[] a) {
		int[] array = new int[a.length];
		try {
			for(int i = 0;i < array.length;i++) {
				array[i] = Integer.parseInt(a[i]);
			}
		}catch(NumberFormatException e) {
		}
		return array;
	}

	private static int[] makeArray2(String[] a) {
		int[] array = new int[a.length];
		for(int i = 0;i < array.length;i++) {
			try {
				array[i] = Integer.parseInt(a[i]);
			}catch(NumberFormatException e) {

			}
		}
		return array;
	}
}
