package fujinoki;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.print("ファイル名：");
		String a = scn.nextLine();
		System.out.print("保存する値：");
		String b = scn.nextLine();
		System.out.println();
		scn.close();

		File file = new File("C:\\output\\");
		outputfile.kmdirs();
		BufferedImage out = null;
		
		try {
			out = new BufferedWriter(new FileWriter(file));
			out.write(b);
			System.out.println("...");
			System.out.println("保存しました!");

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
