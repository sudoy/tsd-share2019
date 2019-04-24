package yamamoto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice4 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("【ファイルの内容を出力するプログラム】");
		System.out.print("ファイル名：");
		String name = scn.next();


		File inputfile = new File("C:\\output");
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(inputfile + "\\" + name));
			System.out.println("...");
			System.out.println("読み込み完了");
			System.out.println("----");
			String line;
			while((line = in.readLine()) != null) {
				System.out.println(line);
			}
		}catch (FileNotFoundException e) {
			System.out.println(inputfile + "\\" + name + "は見つかりませんでした");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(in != null) {
					System.out.println("----");
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		scn.close();
	}
}
