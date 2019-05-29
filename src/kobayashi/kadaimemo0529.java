package kobayashi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class kadaimemo0529 {

	public static void main(String[] args) {


		Scanner scn = new Scanner(System.in);
		System.out.println("ファイル名 : ");
		String a = scn.next();
		System.out.println("保存する値 : ");
		String b = scn.next();

		File outputFile = new File("C:\\output\\" + a);
		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter(outputFile));
			out.write(b);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		System.out.println("保存しました！");
		scn.close();}

	}

}










/*Calendar cal = Calendar.getInstance();

//当日年月日
displayCalendarData(cal);

public static void displayCalendarData(Calendar cal) {

System.out.print(cal.get(Calendar.YEAR) + "年");
System.out.print(cal.get(Calendar.MONTH) + 1 + "月");
System.out.print(cal.get(Calendar.DAY_OF_MONTH) + "日");
}*/

