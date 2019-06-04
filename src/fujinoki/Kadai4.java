package fujinoki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Kadai4 {
	/**
	 * ファイルが配置されているフォルダのパス（デフォルト値）
	 */
	protected static final String DEFAULT_PATH = "c:\\java\\DATA";

	/**
	 * ファイルが配置されているフォルダ(Fileオブジェクト)
	 */
	protected File parentFolder = null;

	/**
	 * 処理実行
	 *
	 * @param path ファイルの配置場所
	 * @return true :処理成功<br>
	 *         false:処理失敗
	 */
	public boolean execute(String path) {
		// パスのチェック
		if (!checkPath(path)) {
			return false;
		}
		// フォルダ内の「DATA_A」から始まるファイル一覧を取得
		File[] dataAFiles = getFiles("DATA_A_");
		if (dataAFiles.length > 0) {
			// データを出力する。
			outputCSVData(dataAFiles, "DATA_A_TOTAL.csv");
		}

		// フォルダ内の「DATA_B」から始まるファイル一覧を取得
		File[] dataBFiles = getFiles("DATA_B_");
		if (dataBFiles.length > 0) {
			// データを出力する
			outputCSVData(dataBFiles, "DATA_B_TOTAL.csv");
		}
		return true;
	}

	/**
	 * 引数のパスをチェックする
	 *
	 * @return true :正常
	 *         false:エラー
	 */
	protected boolean checkPath(String path) {
		// 未設定の場合エラー
		if (path == null || path.trim().length() == 0) {
			System.out.println("パス未設定エラー");
			return false;
		}
		// 存在チェック
		File file = new File(path);
		if (!file.exists()) {
			System.out.println("パス不正エラー");
			return false;
		}

		// ディレクトリであることのチェック
		if (!file.isDirectory()) {
			System.out.println("パス不正エラー");
			return false;
		}
		parentFolder = file;
		return true;
	}

	/**
	 * 親フォルダ以下にある指定した文字列から始まるファイルの一覧を取得する。
	 *
	 * @param fileNamePrefix ファイル名接頭辞
	 * @return ファイルオブジェクト配列
	 */
	protected File[] getFiles(String fileNamePrefix) {
		File[] files = null;
		// ファイル抽出用Filter生成
		FileNameFilterImpl filter = new FileNameFilterImpl(fileNamePrefix);

		// 条件に合致するファイル一覧を取得
		files = parentFolder.listFiles(filter);
		return files;
	}

	/**
	 * 引数のファイルのすべての内容を別のファイルに出力する。
	 *
	 * @param files ファイル一覧
	 * @param outputFileName 出力ファイル名
	 */
	protected void outputCSVData(File[] files, String outputFileName) {
		// 入力ファイルからデータを抽出
		List<String> readDataList = getData(files);
		if (readDataList.size() == 0) {
			System.out.println("データなし");
			return;
		}

		// 出力ファイル
		File outputFile = new File(parentFolder, outputFileName);
		// 存在する場合は削除
		if (outputFile.exists()) {
			outputFile.delete();
		}
		BufferedWriter writer = null;

		try {
			// 出力ファイルを生成
			writer = new BufferedWriter(new FileWriter(outputFile));
			// 全ての行を出力
			for (String linedata: readDataList) {
				// 一行出力
				writer.write(linedata);
				// 改行する
				writer.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 指定した全てのファイルの内容を返す
	 *
	 * @param files ファイル一覧
	 * @return ファイルの内容
	 */
	protected List<String> getData(File[] files) {
		List<String> dataList = new ArrayList<>();
		BufferedReader reader = null;

		try {
			// ファイル一覧のすべてのファイルを処理
			for (File inFile: files) {
				// 入力ファイル
				reader = new BufferedReader(new FileReader(inFile));
				// 一行読む
				String line = reader.readLine();
				// ファイルの最後まで繰り返し
				while (line != null) {
					// 一行分の文字列を格納
					dataList.add(line);
					// 次の行を読む
					line = reader.readLine();
				}
				// ファイルを閉じる
				reader.close();
				reader = null;
			}
			return dataList;
		} catch (Exception e) {
			e.printStackTrace();
			return dataList;
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
