package yamamoto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice6 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("CryptDecode（復号化）");
		System.out.println("--------------------------");
		System.out.print("ファイル名：");
		String name = scn.next();


		File input = new File("C:\\output");
		File inputfile = new File(input,name);
		FileInputStream in = null;
		try {
			in = new FileInputStream(inputfile);
			System.out.println("..........\nデータ：");

			int line;
			while((line = in.read()) != -1) {
				char txt = (char)(line - 1);
				System.out.print(txt);
			}
		}catch (FileNotFoundException e) {
			System.out.println(inputfile + "は見つかりませんでした");
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
		scn.close();
	}
}

