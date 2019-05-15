package fujinoki;

import java.util.HashMap;
import java.util.Map;

public class Sample12_15 {

	public static void main(String[] args) {
		Map<String,Integer> hm = new HashMap<>();
		for(String word : args) {
			Integer freq = hm.get(word);
			hm.put(word, (freq == null ? 1 : freq + 1));//nullの場合は１
		}
		System.out.println(hm);
	}

}
