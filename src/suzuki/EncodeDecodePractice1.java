package suzuki;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.print("ファイル名：");
		String name = scn.nextLine();
		System.out.print("保存する値：");
		String line = scn.nextLine();
		System.out.println();
		scn.close();

		File file = new File("C:\\output\\"+name);
		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter(file));
			out.write(line);
			System.out.println("…\n保存しました！");

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


	}

}
