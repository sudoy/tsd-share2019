package yamamoto;

public class TryCatchPractice {

	public static void main(String[] args) {
		String[] a1 = {"5", "23", "123", "89", "91", "23"};
		String[] a2 = {"5", "23", "a", "89", "b", "c"};
		int[] n1 = makeArray1(a1);
		int[] n2 = makeArray2(a2);
		int[] n3 = makeArray3(a2);
		int[] n4 = makeArray4(a2);
		for(int x:n4) {
			System.out.println(x);
		}
	}

	public static int[] makeArray1(String[] a) {
		int[] ans = new int[a.length];
		for(int i = 0; i < ans.length; i++) {
			ans[i] = Integer.valueOf(a[i]);
		}
		return ans;
	}

	public static int[] makeArray2(String[] a) {
		int[] ans = new int[a.length];
		for(int i = 0; i < ans.length; i++) {
			try {
				ans[i] = Integer.valueOf(a[i]);
			}catch (NumberFormatException e) {
			}

		}
		return ans;
	}
	public static int[] makeArray3(String[] a) {
		int[] ans = new int[a.length];
		try {
			for(int i = 0; i < ans.length; i++) {
				ans[i] = Integer.valueOf(a[i]);
			}
		}catch (NumberFormatException e) {
		}
		return ans;
	}
	public static int[] makeArray4(String[] a) {
		int[] ans = new int[a.length];
		try {
			for(int i = 0; i < ans.length; i++) {
				ans[i] = Integer.valueOf(a[i]);
			}
		}catch (NumberFormatException e) {
			ans = new int[a.length];
		}
		return ans;
	}
}
