package fujinoki;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("ファイル名 : ");
		String x = scn.next();

		File inputFile = new File("C:\\output\\" + x);
		BufferedReader in = null;

		try {

			in = new BufferedReader(new FileReader(inputFile));

			System.out.println("読み込み完了!!");
			System.out.println("------------");
			System.out.println(in.readLine());
			System.out.println("------------");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (in != null) {
					in.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		scn.close();

	}

}
