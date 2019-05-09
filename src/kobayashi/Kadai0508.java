package kobayashi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kadai0508 {

	public static void main(String[] args) {

		System.out.println("整数(1~65535)を入力して下さい。");

		int a = 0;

		for (;;) {
			try {
				Scanner scn = new Scanner(System.in);
				System.out.print("整数を入力 :");

				a = scn.nextInt();

				if (1 <= a && a <= 65535) {
					break;
				} else {
					System.out.println("不正な値です。");
				}
				scn.close();
			} catch (InputMismatchException ie) {
				System.out.println("不正な値です。");
			}
		}
		conversion(a,2);
		conversion(a,16);
	}

	public static void conversion(int x,int y) {
		StringBuilder sb = new StringBuilder();
			int x = num;
		while (a != 0) {
			x / num;
		}

		}
	//for (int i = array.size() - 1; i >= 0; i--) {
	//System.out.print(array.get(i));
}
