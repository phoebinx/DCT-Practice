package practiceDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//
public class WordDict2 {
	HashSet<String> hs;
	HashSet<String> mem;
	List<String> output;

	public static void main(String args[]) {
		WordDict2 obj = new WordDict2();
		List<String> wordDict = new ArrayList<String>();
		String s = "catsanddog";
		String arr[] = { "cat", "cats", "and", "sand", "dog" };
		wordDict.addAll(Arrays.asList(arr));
		List<String> list = obj.wordBreak(s, wordDict);
		//for (String str : list)
			//System.out.println(str);
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		hs = new HashSet<String>(wordDict);
		output = new ArrayList<String>();
		boolean flag = util(s, 0, s.length());
		return output;
	}

	public boolean util(String s, int start, int end) {
		if (start == s.length() || end > s.length())
			return false;
		if (hs.contains(s.substring(start, end))) {
			return true;
		}
		for (int i = start; i < end; i++) {
			if (util(s, start, i) && util(s, i, end)) {
				output.add(s.substring(start, i) + " " + s.substring(i, end));
				return true;
			}
		}

		return false;
	}

}
