package inada;

import java.util.Scanner;

public class Kadai1_0508 {

	private static int x = 0;

	static StringBuilder binary = new StringBuilder();
	static StringBuilder hexadecimal = new StringBuilder();

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		for (;;) {
			System.out.println("整数（1～65535）を入力してください。");
			String y = scn.next();
			try {
				x = Integer.valueOf(y);

				if (x <= 0 || 65536 <= x) {
					System.out.println("不正な値です");
				} else {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("不正な値です");
			}
		}
		scn.close();

		number(2, binary); //何進数か、どのStringBuilderに入れるか
		number(16, hexadecimal);

		//逆順にして出力
		System.out.println("10進数" + x + "は2進数の" + binary.reverse() + "です");
		System.out.println("10進数" + x + "は16進数の" + hexadecimal.reverse() + "です");
	}

	public static void number(int num, StringBuilder stb) {
		for (int i = x; 0 < i; i /= num) {
			int warareta = i % num;

			String str = String.valueOf(warareta);
			switch (str) {
			case "10":
				str = "A";
				break;
			case "11":
				str = "B";
				break;
			case "12":
				str = "C";
				break;
			case "13":
				str = "D";
				break;
			case "14":
				str = "E";
				break;
			case "15":
				str = "F";
				break;
			default:

			}
			stb.append(str);
		}
	}

}
