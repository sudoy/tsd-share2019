package yoshida;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncodeDecodePractice1 {

	public static void main(String[] args) {


		Scanner scn = new Scanner (System.in );
		System.out.print("ファイル名 : ");
		String x = scn.next();
		System.out.print("保存する値 : ");
		String y = scn.next();


		File outputFile = new File("C:\\output\\" + x);
		BufferedWriter out  = null;
		try {


			out = new BufferedWriter(new FileWriter(outputFile));
			out.write(y);
			System.out.println("保存しました！");


		} catch (FileNotFoundException e) {
			e.printStackTrace();
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
