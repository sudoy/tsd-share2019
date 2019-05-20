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

class FilePutTogether{

	private File folder; //引数で指定するフォルダ
	private FilenameFilter filter;
	private String filterName; //引数で指定するフィルターの条件
	private File[] list;
	private File total; //データを書き込むファイル
	private BufferedReader in;
	private BufferedWriter out;

	//フォルダ指定
	public  FilePutTogether(String args, String str) {
		folder = new File(args);
		createFilter(str);
	}

	//フィルターをつくる
	public void createFilter(String str) {
		filterName = str;
		filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if(name.contains(filterName)) {
					return true;
				}else {
					return false;
				}
			}
		};
	}

	//ファイルリストをつくる
	public void setList() throws IOException {
		if(!folder.exists()) {
			throw new IOException("指定したフォルダが見つかりません。");
		}else {
			list = folder.listFiles(filter);
		}
	}

	public File[] getList() {
		return list;
	}

	//書き込むファイルをつくる//読み込むファイルがないときはつくらない
	public void createTotalFile() throws IOException {

		if(getList().length == 0) {
			throw new IOException("フォルダ内に指定したファイルがありません。");
		}else {
			total = new File(folder.getPath() + "\\" + filterName +"_TOTAL.csv");
			total.createNewFile();
		}
	}

	//ファイルに書き込む
	public void writetoTotal() throws IOException {

		out = new BufferedWriter(new FileWriter(total));
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
		createTotalFile();
		writetoTotal();
	}
}

class FilePutTogether2 extends FilePutTogether {

	private Comparator<File> c;

	public FilePutTogether2(String args, String str) {
		super(args, str);
	}

	//Comparatorを実装する
	public void setComparator(){
		c = new Comparator<File>() {
			@Override
			public int compare(File f1, File f2) {
				int i1 = Integer.parseInt(f1.getName().replaceAll("[^0-9]", ""));
				int i2 = Integer.parseInt(f2.getName().replaceAll("[^0-9]", ""));
				return i1 < i2 ? 1 : -1;
			}
		};
	}

	//ファイルリストをソートする
	public void sortFile() {
		setComparator();
		Arrays.sort(getList(), c);
	}

	//ソートを追加
	public void putTogether() throws IOException {
		setList();
		sortFile();
		createTotalFile();
		writetoTotal();
	}
}
