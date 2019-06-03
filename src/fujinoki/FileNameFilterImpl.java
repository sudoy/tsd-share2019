package fujinoki;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 指定した文字列から始まるファイルを抽出するFilter
 */
public class FileNameFilterImpl implements FilenameFilter {
	/**
	 * 抽出ファイル名接頭辞
	 */
	private String prefix = "";

	/**
	 * 引数なしコンストラクタは認めない。
	 */
	@SuppressWarnings("unused")
	private FileNameFilterImpl() {
	}

	/**
	 * コンストラクタ
	 *
	 * @param prefix 抽出ファイル名接頭辞
	 */
	public FileNameFilterImpl(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public boolean accept(File dir, String name) {
		// 指定した文字列から始まるか
		if (name.startsWith(prefix) && !name.startsWith(prefix + "T")) {
			File file = new File(dir, name);
			if (file.isFile()) {
				// ファイルの場合抽出する
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
