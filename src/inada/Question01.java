package inada;

import java.util.Scanner;

public class Question01 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		String[] array1 = new String[4];
		int[] array2 = new int[array1.length];

		int i = 0;
		int j = 0;

		int sum = 0;

		for (; i < array1.length; i++) {
			if (i == 0) {
				System.out.print("  国語 --> ");

			} else if (i == 1) {
				System.out.print("  算数 --> ");

			} else if (i == 2) {
				System.out.print("  理科 --> ");

			} else {
				System.out.print("  社会 --> ");

			}
			array1[i] = scn.next();
		}

		try {

			for (; j < array1.length; j++) {
				array2[j] = Integer.parseInt(array1[j]);
				sum += array2[j];

				if (array2[j] < 0 || 100 < array2[j]) {
					System.out.println("点数には0から100までの整数値を入力してください。");
					System.exit(0);
				}

			}

		} catch (NumberFormatException e) {
			System.out.println("点数には0から100までの整数値を入力してください。");
			System.exit(0);
		}

		double avr = (double) sum / array2.length;

		System.out.print("合計点は " + sum + "、");
		System.out.println("平均点は " + avr + " です。");

		scn.close();
	}

}
