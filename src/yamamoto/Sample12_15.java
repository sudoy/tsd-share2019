package yamamoto;

import java.util.HashMap;
import java.util.Map;

public class Sample12_15 {
	static Integer wi1;

	public static void main(String[] args) {
		Map<String, Integer> hm = new HashMap<String, Integer>();
		for(String word: args) {
			Integer freq = hm.get(word);
			hm.put(word, (freq == null ? 1 : freq + 1));
		}
		System.out.println(hm);
	}

}
