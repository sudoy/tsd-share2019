package suzuki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

public class Kadai_3_0516 {

	public static void main(String[] args) {

		//フォルダ名読み込み
		File folder = new File(args[0]);
		if(!folder.exists()) {
			System.out.println("指定したフォルダが見つかりません。");
		}

		//フィルターをつくる
		FilenameFilter filterA = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				//DATA_Aのときtrue、違うときfalseを返す
				if(name.contains("DATA_A")) {
					return true;
				}else {
					return false;
				}
			}
		};
		FilenameFilter filterB = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				//DATA_Bのときtrue、違うときfalseを返す
				if(name.contains("DATA_B")) {
					return true;
				}else {
					return false;
				}
			}
		};

		//リーダーとライターをつくる
		BufferedReader inA = null;
		BufferedWriter outA = null;
		BufferedReader inB = null;
		BufferedWriter outB = null;

		//ファイルにデータをまとめる
		try {

			//ファイル一覧をつくる
			File[] listA = folder.listFiles(filterA);
			File[] listB = folder.listFiles(filterB);

			//書き込むファイルをつくる//読み込むファイルがないときはつくらない
			File totalA = null;
			File totalB = null;
			if(listA.length == 0) {
				System.out.println("フォルダ内にDATA_Aファイルがありません。");
			}else {
				totalA = new File(folder.getPath() + "\\DATA_A_TOTAL.csv");
				totalA.createNewFile();
			}
			if(listB.length == 0) {
				System.out.println("フォルダ内にDATA_Bファイルがありません。");
			}else {
				totalB = new File(folder.getPath() + "\\DATA_B_TOTAL.csv");
				totalB.createNewFile();
			}

			//DATA_A
			//ストリーム開く
			outA = new BufferedWriter(new FileWriter(totalA));
			for(File f : listA) {
				inA = new BufferedReader(new FileReader(f));
				//リストを読み込んでファイルに書き込む
				String line;
				while((line = inA.readLine()) != null) {
					outA.write(line);
					outA.newLine();
				}
			}

			//DATA_B
			//ストリーム開く
			outB = new BufferedWriter(new FileWriter(totalB));
			for(File f : listB) {
				inB = new BufferedReader(new FileReader(f));
				//リストを読み込んでファイルに書き込む
				String line;
				while((line = inB.readLine()) != null) {
					outB.write(line);
					outB.newLine();
				}
			}

		} catch (IOException e) {

		}catch(NullPointerException e) {

		}finally {
			//ストリーム閉じる
			try {
				if(inA != null) {
					inA.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(outA != null) {
					outA.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(inB != null) {
					inB.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(outB != null) {
					outB.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
