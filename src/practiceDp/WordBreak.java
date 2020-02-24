package practiceDp;

import java.util.Arrays;
import java.util.HashSet;

//https://leetcode.com/problems/word-break/
public class WordBreak {
	String word = "catsandog";
	String arr[] = {"cats", "dog", "sand", "an", "cat"};
	HashSet<String> dict = new HashSet<>(Arrays.asList(arr));
	HashSet<String> mems = new HashSet<String>();
	
	public static void main(String args[]) {
		WordBreak obj = new WordBreak();
		System.out.println(obj.isWord(0, obj.word.length()));
	}
	
	public boolean isWord(int start, int end) {
		if (start == word.length() || end > word.length()+1)
			return false;
		if (dict.contains(word.substring(start,end)))
			return true;
		if (mems.contains(word.substring(start,end)))
			return true;
		for (int i = start; i<end; i++) {
			if (isWord(start,i) && isWord(i,end))
				mems.add(word.substring(start,end));
				return true;
		}
			
		return false;
	}
}
