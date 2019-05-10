package kobayashi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kadai0508 {

	public static void main(String[] args) {

		System.out.println("整数(1~65535)を入力して下さい。");
		Scanner scn = new Scanner(System.in);
		int a = 0;

		for (;;) {
			try {
				System.out.print("整数を入力 :");

				a = scn.nextInt();

				if (1 <= a && a <= 65535) {
					break;
				} else {
					System.out.println("不正な値です。");
				}
			} catch (InputMismatchException ie) {
				System.out.println("不正な値です。");
			}
		}
		scn.close();

		conversion(a, 2);
		conversion(a, 16);
	}

	public static void conversion(int input, int bnum) {

		StringBuilder sb = new StringBuilder();
		int num = input;

		while (num != 0) {
			String rem = String.valueOf(num % bnum);
			switch (rem) {
			case "10":
				rem = "A";
				break;
			case "11":
				rem = "B";
				break;
			case "12":
				rem = "C";
				break;
			case "13":
				rem = "D";
				break;
			case "14":
				rem = "E";
				break;
			case "15":
				rem = "F";
				break;
			}
			sb.append(rem);
			num /= bnum;
		}
		System.out.println("10進数の値 " +  input  + " は " + bnum  + " 進数の " + sb.reverse() + " です。 ");
	}
}
