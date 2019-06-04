package fujinoki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Rensyu_1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int a = 0;
		int b = 0;

		List<Integer> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		int x = 0;
		int y = 0;
		for (;;) {
			try {

				System.out.println("整数(1～65535)を入力してください。");
				x = scn.nextInt();
				y = x;
			} catch (InputMismatchException e) {
				System.out.println("不正な値です");
				scn.close();
			}
			if (1 <= x && x <= 65535) {
				break;
			} else {
				System.out.println("不正な値です");
				continue;
			}
		}
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

		System.out.print("10進数" + y);

		do {
			b = y % 16;
			if (b == 10) {
				list2.add("A" + "");
				y = y / 16;
				continue;
			} else if (b == 11) {
				list2.add("B" + "");
				y = y / 16;
				continue;
			} else if (b == 12) {
				list2.add("C" + "");
				y = y / 16;
				continue;
			} else if (b == 13) {
				list2.add("D" + "");
				y = y / 16;
				continue;
			} else if (b == 14) {
				list2.add("E" + "");
				y = y / 16;
				continue;
			} else if (b == 15) {
				list2.add("F" + "");
				y = y / 16;
				continue;
			}
			list2.add(b + "");
			y = y / 16;

		} while (y > 0);
		Collections.reverse(list2);
		String result2 = String.join("", list2);
		System.out.println("は16進数の" + result2);

	}
}
