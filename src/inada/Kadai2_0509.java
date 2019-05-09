package inada;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Kadai2_0509 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		StringBuilder hachiketa = new StringBuilder();

		for (;;) {
			System.out.println("8桁を入力してください。");
			String input = scn.next();

			try {
				hachiketa = new StringBuilder();	//初期化

				//StringをStringBuilderにしてyyyy-MM-ddの形にする
				hachiketa.append(input).insert(4, "-").insert(7, "-");

				String string = hachiketa.toString(); 	//StringBuilderをStringにする

				//yyyy-MM-ddからyyyy年MM月dd日へ
				DateTimeFormatter nengappi = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
				LocalDate hiduke = LocalDate.parse(string);

				System.out.println(nengappi.format(hiduke));

				//和暦に変換
				Locale locale = new Locale("ja", "JP", "JP");
				DateFormat wareki = new SimpleDateFormat("GGGGyyyy年MM月dd日", locale);
				Date dateHiduke = localDate2Date(hiduke); //LocalDate→Date

				System.out.println(wareki.format(dateHiduke));
				break;

			} catch (DateTimeParseException e) {
				System.out.println("不正です。");
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("不正です。");
			}

		}

		//	うるう年か判定
		int nen = Integer.parseInt(hachiketa.substring(0, 4));
		if (nen % 4 == 0) {
			if (nen % 100 == 0 && nen % 400 != 0) {
				System.out.println("うるう年ではない。");
			} else {
				System.out.println("うるう年です。");
			}
		} else {
			System.out.println("うるう年ではない。");
		}

		scn.close();
	}

	public static Date localDate2Date(final LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}// LocalDateをDateに変換するメソッド?

}
