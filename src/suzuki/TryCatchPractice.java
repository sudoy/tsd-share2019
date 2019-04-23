package suzuki;

public class TryCatchPractice {

	public static void main(String[] args) {

//		String[] a1 = {"5", "23", "123", "89", "91", "23"};
		String[] a2 = {"5", "23", "a", "89", "b", "c"};

		int[] x = makeArray4(a2);
		for(int n : x) {
			System.out.print(n + " ");
		}

	}


	public static int[] makeArray1(String[] a) {

		int[] b = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			int x = Integer.parseInt(a[i]);
			b[i] = x;
		}
		return b;
	}

	public static int[] makeArray2(String[] a) {

		int[] b = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			try {
				int x = Integer.parseInt(a[i]);
				b[i] = x;
			}catch(RuntimeException e) {

			}
		}
		return b;
	}

	public static int[] makeArray3(String[] a) {

		int[] b = new int[a.length];
		int x;
		try {
			for(int i = 0; i < a.length; i++) {
				x = Integer.parseInt(a[i]);
				b[i] = x;
			}
		}catch(RuntimeException e) {

		}
		return b;
	}

	public static int[] makeArray4(String[] a) {

		int[] b = new int[a.length];
		try {
			for(int i = 0; i < a.length; i++) {
				int x = Integer.parseInt(a[i]);
				b[i] = x;
			}
		}catch(RuntimeException e) {
//			for(int i = 0; i < a.length; i++) {
//				b[i] = 0;
//			}
//			Arrays.fill(b, 0);
			b = new int[a.length];

		}
		return b;
	}
}


