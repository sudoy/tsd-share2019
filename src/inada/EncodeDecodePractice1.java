package inada;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice1 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.print("ファイル名 : ");
		String str1 = scn.next();
		System.out.print("保存する値 : ");
		String str2 = scn.next();

		File outputFile = new File("c:\\output\\" + str1);

		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter(outputFile));

			out.write(str2);
			out.newLine();

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(out != null) {
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
