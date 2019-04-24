package yamamoto;

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
		String name = scn.next();
		System.out.print("保存する値：");
		String data = scn.next();

		File output = new File("C:\\output");
		File outputfile = new File(output,name);
		output.mkdirs();
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(outputfile);
			for(int i = 0; i < data.length(); i++) {
				int c = data.charAt(i) + 1;
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


		scn.close();
	}
}

