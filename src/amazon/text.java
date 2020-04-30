	package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class text {
	public static void main(String args[]) {
		String names[] = { "a(1)", "a(6)", "a", "a"};
		String names2[] = { "doc", "doc", "doc(1)" };
		text obj = new text();
		for (String res : obj.fileNaming(names2)) {
			System.out.println(res);
		}
	}

	String[] fileNaming(String[] names) {
		List<String> result = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		int val;
		StringBuilder temp = new StringBuilder();
		String tempName;
		for (String name : names) {
			if (map.containsKey(name)) {
				val = map.get(name);
				String str = name+'('+val+')';
				while (map.containsKey(str)) {
					val = val+1;
					str = name+'('+val+')';
				}
				result.add(str);
	            map.put(name,map.get(name)+1);
	            map.put(str, 1);
			
			} else {
				map.put(name, 1);
				result.add(name);
			}
		}
		return result.toArray(new String[] {});
	}
	
	public void test1() {
		HashSet<String> s = new HashSet<>();
		s.add("g");
	}
}
