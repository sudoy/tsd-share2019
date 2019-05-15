package fujinoki;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Rensyu_2 {
	public static void main(String[] args) throws ParseException {
		Scanner scn = new Scanner(System.in);
		System.out.println("8桁を入力してください。");

		try {
			String a = scn.next();
			int num = Integer.parseInt(a);

			if (10000000 <= num && num < 100000000) {
				LocalDate ld = LocalDate.parse(a, DateTimeFormatter.ofPattern("yyyyMMdd"));
				/*Locale defaultLocale = new Locale("ja", "JP", "JP");
				DateFormat japaneseFormat = new SimpleDateFormat(a,defaultLocale);*/

				System.out.println(ld);
				System.out.print(ld.getyear() + "年" + ld.getMonth() + "月" + ld.getDayOfMonth() + "日");
				/* System.out.println(japaneseFormat.format(ld));*/
			} else {
				System.out.println("不正です。");
			}

		} catch (NumberFormatException e) {
			System.out.println("不正です。");

		}

	}

}
