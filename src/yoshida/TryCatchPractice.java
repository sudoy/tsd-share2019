package yoshida;

public class TryCatchPractice {

	public static void main(String[] args) {
		String[] a1 = {"5", "23", "123", "89", "91", "23"};
		String[] a2 = {"5", "23", "a", "89", "b", "c"};

//		int [] array = makeArray3(a2);
		int [] array = makeArray2(a2);

		for(int x = 0 ; x < a1.length ; x++) {
			System.out.println(array[x]);
		}
	}
	public static int[] makeArray1(String[] a) {
		int[] array = new int [a.length];
		for(int x = 0 ; x < a.length ; x++) {
			int y = Integer.parseInt(a[x]);
			array[x] = y ;
		}
		return array ;
	}

	public static int[] makeArray3(String[] a) {
		int[] array = new int [a.length];
		try {
			for(int x = 0 ; x < a.length ; x++) {
				int y = Integer.parseInt(a[x]);
				array[x] = y ;
			}
		}catch(NumberFormatException e) {

		}
		return array ;
	}

	public static int[] makeArray2(String[] a) {
		int[] array = new int [a.length];
		for(int x = 0 ; x < a.length ; x++) {
			try {
				int y = Integer.parseInt(a[x]);
				array[x] = y ;
			}catch(NumberFormatException e) {

			}

		}return array ;
	}
}
