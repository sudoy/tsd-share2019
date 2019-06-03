package yoshida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

public class Kadai03file {
	public static final String dir = "C:\\DATA";
	public static final String totalA = "DATA_A_TOTAL.csv" ;
	public static final String totalB = "DATA_B_TOTAL.csv" ;
	public static final File outputA = new File(dir,totalA);//最終的にDATA_Aを入れるファイル
	public static final File outputB = new File(dir,totalB);//最終的にDATA_Bを入れるファイル
	public static final String error = "エラーが発生しました。" ;

	public static void main(String[] args) {
		try {
			Kadai03file k = new Kadai03file();
			File input = new File(args[0]);  //コマンド引数の値をファイル化

			k.loopfile(input.list(new FilterA()), outputA, args[0]);//Aファイルのみ読み込み・出力
			k.loopfile(input.list(new FilterB()), outputB, args[0]);//Bファイルのみ読み込み・出力

		}catch(NullPointerException e){
			System.out.println(error);
		}catch(StringIndexOutOfBoundsException e) {
			System.out.println(error);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(error);
		} catch (IOException e) {
			System.out.println(error);
		}
	}

	public void loopfile(String[] input, File output, String args) throws IOException {
		reset(output);
		for (int i = 0; i < input.length; i++) { //A,Bのフィルターをかけた配列のループ
			File inputfile = new File(args,input[i]);//新しくファイルを生成

			if(judge(inputfile) == true) {//ディレクトリ以外のものを読み込み
				writer(inputfile,output);
			}else {
				continue ;
			}
		}
		System.out.println(output + "に読み込み完了しました。");
	}

	public void writer(File input, File output) throws IOException {
		BufferedReader in = null;//このメソッドで起きる例外は全てthrows
		BufferedWriter out = null;

		in = new BufferedReader(new FileReader(input));
		out = new BufferedWriter(new FileWriter(output, true));//ファイルを追加（上書きではない）

		String line;
		while ((line = in.readLine()) != null) {
			out.write(line);
			out.newLine();
		}
		if (in != null) {
			in.close();
		}
		if (out != null) {
			out.close();
		}
	}

	public void reset (File output) {//何度でも上書き可能にする
		if(output.exists()) {
			output.delete();
		}
	}

	public boolean judge(File inputfile) {//ファイルと同名のディレクトリを読み込まない
		if(!inputfile.isDirectory()) {
			return true ;
		}else {
			return false ;
		}
	}
}

class FilterA implements FilenameFilter {
	@Override
	public boolean accept(File dir, String name) {
		return name.matches("^DATA_A_[0-9]{8}.csv$");//ファイル名が完全一致するもの以外false
	}
}

class FilterB implements FilenameFilter {
	@Override
	public boolean accept(File dir, String name) {
		return name.matches("^DATA_B_[0-9]{8}.csv$");//ファイル名が完全一致するもの以外false
	}
}
