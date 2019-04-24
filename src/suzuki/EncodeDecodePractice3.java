package suzuki;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.print("ファイル名：");
		String name = scn.nextLine();
		System.out.println();
		scn.close();

		File file = new File("C:\\output\\"+ name);
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));

			System.out.println("…\n読み込み完了！");
			System.out.println("-------");
			String line;
			while((line = in.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("-------");

		} catch (IOException e) {
			e.printStackTrace();
		}finally {

		}
	}

}
