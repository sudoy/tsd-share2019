package kobayashi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kadai0508 {

	public static void main(String[] args) {

		System.out.println("整数(1~65535)を入力して下さい。");

		ArrayList<Integer> array = new ArrayList<>();
		int a = 0;

		for (;;) {
			try {
				Scanner scn = new Scanner(System.in);
				System.out.print("整数を入力 :");

				a = scn.nextInt();

				if (a >= 1 && a <= 65535) {
					break;
				} else {
					System.out.println("不正な値です。");
				}
				scn.close();
			} catch (InputMismatchException ie) {
				System.out.println("不正な値です。");
			}
		}
		while (a >= 1) {
			array.add(a % 2);
			a = a / 2;
		}
		for (int i = array.size() - 1; i >= 0; i--) {
			System.out.print(array.get(i));
		}
	}
}
