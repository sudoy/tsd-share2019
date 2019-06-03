package jp.co.tsd.training2019.yamamoto;

import java.util.ArrayList;

public class Question03_1 {

	public static void main(String[] args) {
		// SyainListインスタンス生成
        SyainList sl = new SyainList();

        // 社員生成およびSyainListインスタンスへ追加（パターン１）
        sl.addSyain("1", "山田", "技術部");
        sl.addSyain("2", "佐藤", "営業部");

        // 社員生成およびSyainListインスタンスへ追加（パターン２）
        sl.add(new Syain("3", "井上", "営業部"));

        // 社員生成およびSyainListインスタンスへ追加（パターン３）
        Syain s2 = new Syain();
        s2.setId("4");
        s2.setName("田口");
        s2.setBusyo("総務部");
        sl.add(s2);

        // 社員一覧出力
        for(Syain s : sl) {
            System.out.println(s);
        }
        System.out.println(String.format("\n計 %d 名", sl.size()));
	}

}

class Syain{
	private String	id = "";
	private String	name = "";
	private String	busyo = "";
	public	Syain() {
	}
	public	Syain(String id, String name, String busyo) {
		this.id = id;
		this.name = name;
		this.busyo = busyo;
	}
	public String	toString() {
		return id + " " + name + " " + busyo;
	}
}
 class SyainList extends ArrayList<Syain>{

 }