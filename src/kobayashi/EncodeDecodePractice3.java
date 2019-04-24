package kobayashi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice3 {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("ファイル名 : ");
		String a = scn.next();

		File inputFile = new File("C:\\output\\" + a);
		BufferedReader in = null;

		try {
			System.out.println("読み込み完了！");
			in = new BufferedReader(new FileReader(inputFile));

			String line;
			while((line = in.readLine()) != null) {
				System.out.println("----");
				System.out.println(line);
				System.out.println("----");
			}

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
