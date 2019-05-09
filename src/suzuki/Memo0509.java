package suzuki;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Memo0509 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int input;
		do {
			try {
				System.out.println("8桁を入力してください。");
				input = scn.nextInt();
				if(9999999 < input && input < 100000000) { //8桁ならループ終わり.length
					break;
				}else {
					System.out.println("不正な値です。");
				}
			}catch(InputMismatchException e) {
				System.out.println("不正な値です。");
				scn.next();
			}
		}while(true);

		try {
			DatePrint date = new DatePrint(input);
			date.printAd();
			date.printJc();
			date.judge();
		} catch (DateTimeException e) {
			System.out.println("日付に変換できません。");
			System.out.println(e.getMessage());
		}

		scn.close();
	}
}

class DatePrint{

	private int year;
	private int month;
	private int day;
	private LocalDate ld;

	public DatePrint(int input) {
		String inputS = String.valueOf(input);
		year =  Integer.valueOf(inputS.substring(0, 4));
		month = Integer.valueOf(inputS.substring(4, 6));
		day = Integer.valueOf(inputS.substring(6));
		ld = LocalDate.of(year, month, day);
	}

	public void printAd() { //西暦
		DateTimeFormatter westC = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
		System.out.println(ld.format(westC));
	}

	public void printJc() { //和暦
		JapaneseDate jd = JapaneseDate.from(ld);
		DateTimeFormatter japanC = DateTimeFormatter.ofPattern("Gy年MM月dd日");
		if(ld.isAfter(LocalDate.of(2019, 4, 30))) {
			String jds = String.valueOf(jd.format(japanC));
			System.out.println(jds.replace("元号", "令和"));
		}else {
			System.out.println(jd.format(japanC));
		}
	}
	public void judge() { //うるう年かどうか
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