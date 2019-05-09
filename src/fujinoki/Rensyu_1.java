package fujinoki;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Rensyu_1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int a = 0;

		List<Integer> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();

		
			System.out.print("10進数" + x);

			do {
				a = x % 2; //整数を2で割った余りをyに代入
				list1.add(a); //リストに追加
				x = x / 2; //商をxに代入

			} while (x > 0); //商が0ではそれ以上割れないから
			Collections.reverse(list1);
			String str = String.valueOf(list1);
			String result1 = String.join("", str);
			System.out.println("は2進数の" + result1);

		}
		;

		do {
			a = x % 16;
			if (a == 10) {
				System.out.println("A");
			} else if (a == 11) {
				System.out.println("B");
			} else if (a == 12) {
				System.out.println("C");
			} else if (a == 13) {
				System.out.println("D");
			} else if (a == 14) {
				System.out.println("E");
			} else if (a == 15) {
				System.out.println("F");
			}
			list2.add(a + "");
			x = x / 16;

		} while (x > 0);
		Collections.reverse(list2);
		String result2 = String.join("", list2);
		System.out.println("10進数" + x + "は16進数の" + result2);

	};

}
