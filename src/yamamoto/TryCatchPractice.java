package yamamoto;

public class TryCatchPractice {

	public static void main(String[] args) {
		String[] a1 = {"5", "23", "123", "89", "91", "23"};
		int[] n1 = makeArray1(a1);
		for(int x:n1) {
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
}
