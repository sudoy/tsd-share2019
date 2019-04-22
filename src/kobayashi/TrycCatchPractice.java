package kobayashi;

public class TrycCatchPractice {

	public static void main(String[] args) {
		//String[] a1 = {"5","23","123","89","91","23"};
		String[] a2 = {"5","23","a","89","b","c"};


		int[] array =makeArray3(a2);

		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static int[] makeArray1(String[] a) {
		int array[] = new int[a.length];

		for(int i =0 ; i < a.length ; i++) {
			int x = Integer.parseInt(a[i]);
			array[i] = x;
		}
		return array;
	}
	public static int[] makeArray2(String[] a) {
		int array[] = new int[a.length];

		for(int i =0 ; i < a.length ; i++) {
			try {
				int x = Integer.parseInt(a[i]);
				array[i] = x;
			}catch(NumberFormatException e){

			}
		}
		return array;
	}
	public static int[] makeArray3(String[] a) {
		int array[] = new int[a.length];

		for(int i =0 ; i < a.length ; i++) {
			int x = Integer.parseInt(a[i]);
			array[i] = x;
		}
		return array;
	}
}