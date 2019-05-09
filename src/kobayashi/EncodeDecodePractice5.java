package kobayashi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice5 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("ファイル名 : ");
		String a = scn.nextLine();
		System.out.println("保存する値 : ");
		String b = scn.nextLine();

		File outputFile = new File("C:\\output\\");
		File file = new File(outputFile,a);
		FileOutputStream out = null;

		outputFile.mkdir();

		try {
			out = new FileOutputStream(file);
			for(int i = 0; i < b.length() ;i++ ) {
				int c = b.charAt(i) + 1;
				out.write(c);
			}

			System.out.println("暗号化が終わりました。");

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
