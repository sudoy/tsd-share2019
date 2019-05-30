package kobayashi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class kadai0529 {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();

		System.out.print("カレンダーを出力する年月を入力してください。");//年月の入力
		Scanner scn = new Scanner(System.in);
		String y;
		int m = 0;

		for (;;) {
			try {
				 y = scn.next();
				 m = 0;

				if (y.length() == 4) {
					m = scn.nextInt();
				}
				if (1 <= m && m <= 12) {
					break;
				} else {
					System.out.println("入力内容が不正です。もう一度入力してください。");
				}
			} catch (InputMismatchException ie) {
				System.out.println("入力内容が不正です。もう一度入力してください。");
				scn.nextLine();
			}
		}
		scn.close();

		System.out.println("ファイルに出力しました。");

		LocalDate date = LocalDate.of(Integer.valueOf(y), m,1);//今月1日(変数として使うと便利)
		date.getDayOfWeek();
		date.plusMonths(1).minusDays(1);//今月の最終日


		File inputFile = new File("C:\\HTMLCSS課題\\kadai0529.html");
		File outputFile = new File("C:\\HTMLCSS課題\\kadai0529.html");

		BufferedReader in = null;
		BufferedWriter out = null;


		try {
			in = new BufferedReader(new FileReader(inputFile));
			out = new BufferedWriter(new FileWriter(outputFile));

			String line;
			while((line = in.readLine()) != null){
				out.write(line);
				out.newLine();
				//out.println(line); //上2行の代わり
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		}finally{
			try {
				if (in != null) {
				in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(out != null) {
				out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


}
