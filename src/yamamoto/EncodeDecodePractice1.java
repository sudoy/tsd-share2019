package yamamoto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("ファイル名：");
		String name = scn.next();
		System.out.print("保存する値：");
		String data = scn.next();
		
		File outputfile = new File("C:\\output\\" +name);
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(outputfile));
			out.write(data);
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
