package inada;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice5 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("ファイル名 : ");
		String str1 = scn.nextLine();
		System.out.print("保存する値 : ");
		String str2 = scn.nextLine();

		File output = new File("c:\\output\\");

		File outputFile = new File(output, str1);

		if (!output.exists()) {
			try {
				outputFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileWriter out = null;
		try {
			out = new FileWriter(outputFile);

			int c = 0;
			for (int i = 0; i < str2.length(); i++) {
				c = str2.charAt(i) + 1;
				out.write(c);

			}

			System.out.println("暗号化が終わりました。");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
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

		scn.close();
	}

}
