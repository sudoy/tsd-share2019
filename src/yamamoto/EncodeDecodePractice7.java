package yamamoto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice7 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("ファイルの作成…0・/ファイルの読み込み…1：");
		int x = scn.nextInt();


		if (x == 0) { // 作成
			System.out.println("CryptEncode（暗号化）");
			System.out.println("--------------------------");
			System.out.print("ファイル名：");
			String name = scn.next();
			System.out.print("保存する値：");
			String data = scn.next();

			File output = new File("C:\\output");
			File outputfile = new File(output,name);
			output.mkdirs();
			FileOutputStream out = null;
			int sum = 0;
			int add = 0;
			try {
				out = new FileOutputStream(outputfile);
				for(int i = 0; i < data.length(); i++) {
					sum += data.charAt(i);
				}
				add =sum % data.length();
				out.write(add);
				for(int i = 0; i < data.length(); i++) {
					int c = data.charAt(i) + add;
					out.write(c);
				}
				System.out.println("......\n暗号化が終わりました。");
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


		} else if (x == 1) { // 読み込み
			System.out.println("CryptDecode（復号化）");
			System.out.println("--------------------------");
			System.out.print("ファイル名：");
			String name = scn.next();

			File input = new File("C:\\output");
			File inputfile = new File(input,name);
			FileInputStream in = null;
			int cord = 0;
			try {
				in = new FileInputStream(inputfile);
				System.out.println("..........\nデータ：");

				int line;
				cord = in.read();
				while ((line = in.read()) != -1) {
					char txt = (char) (line - cord);
					System.out.print(txt);
				}
			} catch (FileNotFoundException e) {
				System.out.println(inputfile + "は見つかりませんでした");
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (in != null) {
						in.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		scn.close();
	}
}
