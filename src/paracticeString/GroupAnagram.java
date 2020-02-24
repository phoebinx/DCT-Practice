package paracticeString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagram {
	public static void main(String args[]) {
		GroupAnagram obj = new GroupAnagram();
		String[] Input = { "eat", "tea", "tan", "ate", "nat", "bat" };
		List<List<String>> res =obj.groupAnagrams(Input);
		for (List<String> list:res) {
			for (String s : list) {
				System.out.print(s+" ");
			}
			System.out.println();
		}
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> hm = new HashMap<>();

		for (String str : strs) {
			char[] temp = str.toCharArray();
			Arrays.sort(temp);
			String strTemp = new String(temp);
			if (hm.containsKey(strTemp)) {
				hm.get(strTemp).add(str);
			} else {
				List<String> tList = new ArrayList<>();
				tList.add(str);
				hm.put(strTemp, tList);
			}
		}
		List<List<String>> res = new ArrayList<>(hm.values());
		return res;
	}

}
