package suzuki;

public class TryCatchPractice {

	public static void main(String[] args) {

		String[] a1 = {"5", "23", "123", "89", "91", "23"};
		String[] a2 = {"5", "23", "a", "89", "b", "c"};
		String[] a3 = {"5", "23", "89"};

		int[] x = makeArray4(a2);
		for(int n : x) {
			System.out.print(n + ",");
		}


	}

	public static int[] makeArray1(String[] a) {

		int[] b = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			int b2 = Integer.parseInt(a[i]);
			b[i] = b2;
		}
		return b;
	}

	public static int[] makeArray2(String[] a) {

		int[] b = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			int b2;
			try {
				 b2 = Integer.parseInt(a[i]);
				 b[i] = b2;
			}catch(Throwable e){

			}
		}
		return b;
	}

	public static int[] makeArray3(String[] a) {

		int[] b = new int[a.length];
		int b2;
		try {
			for(int i = 0; i < a.length; i++) {
				b2 = Integer.parseInt(a[i]);
				b[i] = b2;
			}
		}catch(Throwable e) {

		}
		return b;
	}

	public static int[] makeArray4(String[] a) {

		int[] b = new int[a.length];
		int b2;
		try {
			for(int i = 0; i < a.length; i++) {
				b2 = Integer.parseInt(a[i]);
				b[i] = b2;
			}
		}catch(Throwable e) {
			for(int i = 0; i < a.length; i++) {
				b[i] = 0;
			}
		}
		return b;
	}

}


