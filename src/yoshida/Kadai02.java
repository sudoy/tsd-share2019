package yoshida;

import java.time.LocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Kadai02 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int date = 0;

		for(; ;) {
			try {
				System.out.println("8桁を入力してください。");
				String num = scn.nextLine();
				date = Integer.parseInt(num);

				if(num.length() == 8) {
					break ;
				}else {
					System.out.println("不正です。");
				}
			}catch(NumberFormatException e1) {
				System.out.println("不正です。");
				continue ;
			}
		}
		String text = Integer.toString(date);//LocalDateの引数に使うためStringに変換
		LocalDate year = LocalDate.parse(text, DateTimeFormatter.BASIC_ISO_DATE);

		System.out.println
		(year.getYear()+ "年" + year.getMonthValue()+ "月" + year.getDayOfMonth() + "日" );

		JapaneseDate jpDate = JapaneseDate.of(year.getYear(),year.getMonthValue(),year.getDayOfMonth());
//		和暦にするためJapaneseDateを使用

//		System.out.println(jpDate);

		DateTimeFormatter f = DateTimeFormatter.ofPattern("Gy年M月d日");
		f.withChronology(JapaneseChronology.INSTANCE);
		System.out.println(f.format(jpDate));

//		よくわかりませんでした。


		if(year.isLeapYear()) {
			System.out.println("うるう年です。");
		}else {
			System.out.println("うるう年ではない。");
		}
	}

}
