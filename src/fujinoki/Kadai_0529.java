package fujinoki;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Scanner;

public class Kadai_0529 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String nengetsu;

		for (;;) {
			try {
				System.out.println("カレンダーを出力する年月を入力してください。");
				nengetsu = scn.next();
				int year = Integer.valueOf(nengetsu.substring(0, 4));
				char kanma = nengetsu.charAt(4);
				int month = Integer.valueOf(nengetsu.substring(5));

				if (1000 <= year && 1 <= month && month <= 12 && kanma == ',') {
					break;
				} else {
					System.out.println("不正な値です");
					continue;
				}
			} catch (StringIndexOutOfBoundsException | NumberFormatException e) {
				System.out.println("不正な値ですe");
			}
		}

		int first = 1;
		int year = Integer.valueOf(nengetsu.substring(0, 4));
		int month = Integer.valueOf(nengetsu.substring(5));

		Calendar cal = Calendar.getInstance();

		//その月が何曜日から始まるか,日曜日が１
		cal.set(year, month - 1, first);
		int week = cal.get(Calendar.DAY_OF_WEEK);

		//月末
		cal.set(year, month - 1, first);
		int thislast = cal.getActualMaximum(Calendar.DATE);

		try {
			FileWriter file = new FileWriter("C:\\html\\カレンダー.html");

			PrintWriter pw = new PrintWriter(new BufferedWriter(file));

			pw.println(
					"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
			pw.println("<title>カレンダー</title>");
			pw.println("</head>");
			pw.println("<body>");
			pw.println("<table>");
			pw.println("<tr>");
			pw.println("<td align=\"center\">" + year + "年</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td align=\"center\">" + month + "月</td>");
			pw.println("</tr>");
			pw.println("<tr>");
			pw.println("<td align=\"center\">");
			pw.println("<table border=1>");
			pw.println("<tr>");
			pw.println("<td><font color=\"red\">日</front></td>");
			pw.println("<td>月</td>");
			pw.println("<td>火</td>");
			pw.println("<td>水</td>");
			pw.println("<td>木</td>");
			pw.println("<td>金</td>");
			pw.println("<td><font color=\"blue\">土</front></td>");
			pw.println("</tr>");
			pw.println("<tr>");

			int x = 2 - week;

			for (int i = x; i <= thislast; i += 7) {
				if (i <= 0) {
					pw.println("<td></td>");
				} else {
					pw.println("<td><font color=\"red\">" + i + "</font></td>");
				}

				for (int j = i + 1; j <= i + 6; j++) {
					if (thislast < j || j <= 0) {
						pw.println("<td></td>");
					} else if (j == i + 6) {
						pw.println("<td><font color=\"blue\">" + j + "</front></td>");
					} else {
						pw.println("<td>" + j + "</td>");
					}
				}
				pw.println("</tr>");
			}
			System.out.println("ファイルに出力しました。");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scn.close();
	}
}
