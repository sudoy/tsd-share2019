package suzuki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class Kadai_3_0517 {

	public static void main(String[] args) {

		FilePutTogether a = new FilePutTogether(args[0], "DATA_A");
		FilePutTogether2 b = new FilePutTogether2(args[0], "DATA_B");

		try {
			a.putTogether();
			b.putTogether();
			System.out.println("完了しました。");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			a.closeStream();
			b.closeStream();
		}
	}
}
//課題３
class FilePutTogether{

	private File folder; //引数で指定するフォルダ
	private String filterName; //引数で指定するフィルターの条件
	private File[] list;
	private BufferedReader in;
	private BufferedWriter out;
	public static final String TOTAL_NAME = "_TOTAL.csv";

	//フォルダ指定
	public  FilePutTogether(String args, String str) {
		folder = new File(args);
		filterName = str;
	}

	//フィルターをつくる
	public FilenameFilter createFilter() {
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				File nameFile = new File(folder.getPath() + "\\" + name);
				//指定したファイル名と一致＆フォルダではない＆_TOTAL.csvファイルではない→trueを返す
				if(name.contains(filterName) && nameFile.isFile() && !name.contains(TOTAL_NAME)) {
					return true;
				}else {
					return false;
				}
			}
		};
		return filter;
	}

	//ファイルリストをつくる
	public void setList() throws IOException {
		if(!folder.exists()) {
			throw new IOException("指定したフォルダが見つかりません。");
		}else {
			list = folder.listFiles(createFilter());
		}
	}

	public File[] getList() {
		return list;
	}

	//書き込むファイルをつくる
	public File createTotalFile() throws IOException {
		if(getList().length == 0) { //読み込むファイルがないときはつくらない
			throw new IOException("フォルダ内に指定したファイルがありません。");
		}else {
			File total = new File(folder.getPath() + "\\" + filterName + TOTAL_NAME);
			return total;
		}
	}

	//ファイルに書き込む
	public void writetoTotal() throws IOException {

		out = new BufferedWriter(new FileWriter(createTotalFile()));
		for(File f : getList()) {
			in = new BufferedReader(new FileReader(f));
			//リストを読み込んでファイルに書き込む
			String line;
			while((line = in.readLine()) != null) {
				out.write(line);
				out.newLine();
			}
		}
	}

	//ストリーム閉じる
	public void closeStream() {
		try {
			if(in != null) {
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if(out != null) {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//全部
	public void putTogether() throws IOException {
		setList();
		writetoTotal();
	}
}

//課題４
class FilePutTogether2 extends FilePutTogether {

	public FilePutTogether2(String args, String str) {
		super(args, str);
	}

	//Comparatorを実装する
	public Comparator<File> setComparator(){
		 Comparator<File> c = new Comparator<File>() {
			@Override
			public int compare(File f1, File f2) {
				int i1 = Integer.parseInt(f1.getName().replaceAll("[^0-9]", ""));
				int i2 = Integer.parseInt(f2.getName().replaceAll("[^0-9]", ""));
				return i1 < i2 ? 1 : -1;
			}
		};
		return c;
	}

	//ソートを追加
	public void putTogether() throws IOException {
		setList();
		Arrays.sort(getList(), setComparator());
		writetoTotal();
	}
}
