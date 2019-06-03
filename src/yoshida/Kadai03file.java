package yoshida;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
public class Kadai03file {
	private static final String dir = "C:\\DATA";
	private static final String totalA = "DATA_A_TOTAL.csv" ;
	private static final String totalB = "DATA_B_TOTAL.csv" ;
	public static void main(String[] args) {
	String error = "エラーが発生しました。" ;
		try {
			Files f = new Files();
			File input = new File(args[0]);  //コマンド引数の値をファイル化
			File outputA = new File(dir,totalA);//最終的にDATA_Aを入れるファイル
			File outputB = new File(dir,totalB);//最終的にDATA_Bを入れるファイル

			f.loopfile(input.list(new FilterA()), outputA, args[0]);//Aファイルのみ読み込み・出力
			f.loopfile(input.list(new FilterB()), outputB, args[0]);//Bファイルのみ読み込み・出力
//			f.sort(input.list(new FilterB()), outputB, args[0]);

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
}

class Files{

	public void loopfile(String[] input, File output, String args) throws IOException {
		reset(output);
		for (int i = 0; i < input.length; i++) { //Aのフィルターをかけた配列のループ
			File inputfile = new File(args,input[i]);//新しくファイルを生成
			writer(inputfile, output);
		}
		System.out.println(output + "に読み込み完了しました。");
	}

	public void sort(String[] input, File output, String args) throws IOException  {
		reset(output);
		Arrays.sort(input,new Com());//読み込んだファイルの配列をコンパレーターでソートする
		for (int i = 0; i < input.length; i++) {
			File inputfile = new File(args , input[i]);//配列で抽象パスを作成
			writer(inputfile, output);						   //読み込んだ配列でファイルを作成
		}
		System.out.println(output + "に降順で読み込み完了しました。");
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

	public void reset (File output) {
		if(output.exists() == true) {
			output.delete();
		}
	}
}

class FilterA implements FilenameFilter {
	@Override
	public boolean accept(File dir, String name) {
		return name.matches("^DATA_A_[0-9]{8}\\.csv$");//ファイル名が完全一致するもの以外false
	}
}

class FilterB implements FilenameFilter {
	@Override
	public boolean accept(File dir, String name) {
		return name.matches("^DATA_B_[0-9]{8}\\.csv$");//ファイル名が完全一致するもの以外false
	}
}

class Com  implements Comparator<String>{//Arraysでメソッドを使うために配列の型と合わせている
	@Override
	public int compare(String o1,String o2) {
		return o2.compareTo(o1);//File名の比較
	}
}

