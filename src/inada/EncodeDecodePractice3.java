package inada;

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
		String str1 = scn.next();

		File inputFile = new File("c:\\output\\", str1);

		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(inputFile));

			System.out.println("読み込み完了！");

			String line = null;
			try {
				line = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(line);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(in != null) {
					in.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		scn.close();

	}

}
