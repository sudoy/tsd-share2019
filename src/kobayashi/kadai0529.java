package kobayashi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class kadai0529 {

	public static void main(String[] args) {

		System.out.print("カレンダーを出力する年月を入力してください。");//年月の入力
		Scanner scn = new Scanner(System.in);
		String y;
		int m = 0;
		int linecount = 1;

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

		LocalDate first = LocalDate.of(Integer.valueOf(y), m,1);//入力した月の初日(変数として使う)
		first.getDayOfWeek();//1日の曜日

		int last = first.plusMonths(1).minusDays(1).getDayOfMonth();//入力した月の最終日//数字に変換


		File inputFile = new File("C:\\HTMLCSS課題\\kadai0529.html");
		File outputFile = new File("C:\\HTMLCSS練習\\2_kadai0529.html");

		BufferedReader in = null;
		BufferedWriter out = null;

		try {
			in = new BufferedReader(new FileReader(inputFile));
			out = new BufferedWriter(new FileWriter(outputFile));

			String line;
			while((line = in.readLine()) != null){


				if(linecount == 10) {
					out.write("<td align=\"center\">" +first.getYear() +"年</td>");
				}else if(linecount == 13 ) {
					out.write( "<td align=\"center\">" +first.getMonthValue() + "月</td>");
				}else if(linecount == 27){


					switch(first.getDayOfWeek()) {
					case SUNDAY:
						out.write("<td><font color=\"red\">1</font></td>");
					case MONDAY:
						out.write("<td>" + 1 + "</td>");
					case TUESDAY:
						out.write("<td>" + 1 + "</td>");
					case WEDNESDAY:
						out.write("<td>" + 1 + "</td>");
					case THURSDAY:
						out.write("<td>" + 1 + "</td>");
					case FRIDAY:
						out.write("<td>" + 1 + "</td>");
					case SATURDAY:
						out.write("<td><font color=\"blue\">14</font></td>");
					}

					out.write("<tr>");
					for(int i = 1 ; i <= 7; i++) {
						out.write("<td>" + i + "</td>");
						}
					out.write("</tr>");

					out.write("<tr>");
					for(int i = 8 ; i <= 14; i++) {
						out.write("<td>" + i + "</td>");
					}
					out.write("</tr>");

					out.write("<tr>");
					for(int i = 15 ; i <= 21; i++) {
						out.write("<td>" + i + "</td>");
					}
					out.write("</tr>");

					out.write("<tr>");
					for(int i = 22 ; i <= 28; i++) {
						out.write("<td>" + i + "</td>");
					}
					out.write("</tr>");

					out.write("<tr>");
					for(int i = 29 ; i <= last; i++) {
						out.write("<td>" + i + "</td>");
					}
					out.write("</tr>");


				}else if(linecount >= 28 && linecount <= 71){//スキップするところ


				}else {
					out.write(line);
				}
				out.newLine();
				linecount++;
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
