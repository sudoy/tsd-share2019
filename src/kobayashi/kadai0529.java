package kobayashi;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class kadai0529 {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();//カレンダークラス

		System.out.print("カレンダーを出力する年月を入力してください。");

		Scanner scn = new Scanner(System.in);

		for (;;) {
			try {
				String y = scn.nextLine();
				String m = scn.next();

				if (y.length() == 4) {
//					&& m.matches("[0-12]") ) {
//				}
					break;
				} else {
						System.out.println("入力内容が不正です。もう一度入力してください。");
				}
			} catch (InputMismatchException ie) {
				System.out.println("入力内容が不正です。もう一度入力してください。");
			}
		}
		scn.close();

		System.out.println("ファイルに出力しました。");

	}

}
