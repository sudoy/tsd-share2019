package suzuki;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kadai0509 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int date;
		do {
			try {
				System.out.println("8桁を入力してください。");
				date = scn.nextInt();
				if(9999999 < date && date < 100000000) { //8桁ならループ終わり
					break;
				}else {
					System.out.println("不正な値です。");
				}
			}catch(InputMismatchException e) {
				System.out.println("不正な値です。");
				scn.next();
			}
		}while(true);

		//年、月、日に分ける
		String dateS = String.valueOf(date);
		int year =  Integer.valueOf(dateS.substring(0, 4));
		int month = Integer.valueOf(dateS.substring(4, 6));
		int day = Integer.valueOf(dateS.substring(6));

		try {
			LocalDate ld = LocalDate.of(year, month, day);
			DateTimeFormatter westC = DateTimeFormatter.ofPattern("yyyy年MM月dd日"); //西暦
			System.out.println(ld.format(westC));

			JapaneseDate jd = JapaneseDate.from(ld);
			DateTimeFormatter japanC = DateTimeFormatter.ofPattern("Gy年MM月dd日"); //和暦
			if(ld.isAfter(LocalDate.of(2019, 4, 30))) {
				String jds = String.valueOf(jd.format(japanC));
				System.out.println(jds.replace("元号", "令和"));
			}else {
				System.out.println(jd.format(japanC));
			}

			judge(year); //うるう年かどうか

		} catch (DateTimeException e) {
			System.out.println("日付に変換できません。");
			System.out.println(e.getMessage());
		}

		scn.close();
	}

	public static void judge(int year) {
		if(year % 4 != 0) {
			System.out.println("うるう年ではない。");
		}else if(year % 100 != 0) {
			System.out.println("うるう年です。");
		}else if(year % 400 != 0) {
			System.out.println("うるう年ではない。");
		}else {
			System.out.println("うるう年です。");
		}
	}
}


//8桁を入力してください。
//
//199999999999
//不正です。
//
//aaa19203
//不正です。
//
//19720328
//
//1972年03月28日
//昭和47年03月28日
//うるう年ではない。
//
//20000328
//2000年03月28
//平成03年03月28日
//うるう年です。