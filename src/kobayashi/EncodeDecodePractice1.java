package kobayashi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice1 {

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
		}
		System.out.println("保存しました！");
		scn.close();
	}

}
