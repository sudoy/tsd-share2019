package suzuki;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice5 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("CryptEncode（暗号化）");
		System.out.println("--------------------------");
		System.out.print("ファイル名：");
		String name = scn.nextLine();
		System.out.print("保存する値：");
		String line = scn.nextLine();
		System.out.println();
		scn.close();

		File folder = new File("C:\\output");
		folder.mkdir();

		File file = new File(folder,name);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);

			int s = 0;
			for(int i = 0; i < line.length(); i++) {
				s += line.charAt(i);
			}
			int p = s % line.length();
			for(int i = 0; i < line.length(); i++) {
				int c = line.charAt(i) + p;
				out.write(c);
			}

			System.out.println("...........\n暗号化が終わりました。");

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
