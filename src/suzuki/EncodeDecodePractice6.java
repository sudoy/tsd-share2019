package suzuki;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice6 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("CriptDecode（復号化）");
		System.out.println("--------------------------");
		System.out.print("ファイル名：");
		String name = scn.nextLine();
		scn.close();

		File folder = new File("C:\\output");
		folder.mkdir();

		File file = new File(folder, name);
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(file));

			System.out.println("...........");
			System.out.print("データ：");

			String line;
			while((line = in.readLine()) != null) {
				int s = 0;
				for(int i = 0; i < line.length(); i++) {
					s += line.charAt(i);
				}
				int p = s % line.length();
				for(int i = 0; i < line.length(); i++) {
					char c = (char)(line.charAt(i) - p);
					System.out.print(c);
				}
			}

		}catch(FileNotFoundException e) {
			System.out.println(file + "は見つかりませんでした");
		} catch (IOException e) {
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

	}

}
