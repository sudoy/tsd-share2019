package kobayashi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kadai0509 {

	public static void main(String[] args) {

		ArrayList<Integer> array = new ArrayList<>();

		//DateTimeFormatter f = DateTimeFormatter.ofPattern("Gy年M月d日");
		//JapaneseDate d = JapaneseDate.of();
		int year = 0;

		for (;;) {
			try {
				System.out.println("8桁を入力して下さい。");

				Scanner scn = new Scanner(System.in);
				System.out.print("8桁を入力 :");
				year = scn.nextInt();

				array.add(year);
				if (array.size() <= 4) {
					break;
				} else {
					System.out.println("不正です");
				}
				scn.close();
			} catch (InputMismatchException ie) {
				System.out.println("不正です。");
			}
		}
		//JapaneseDate japaneseDate = JapaneseDate.of();
		//System.out.println(f.format(d));

		//String numstr = String.valueOf(a);

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					System.out.println("うるう年です");
				}
			}else{
				System.out.println("うるう年ではありません");
			}
		}else{
			System.out.println("うるう年ではありません");
		}
	}
}
