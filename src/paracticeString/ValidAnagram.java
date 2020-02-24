package paracticeString;

import java.util.HashMap;
import java.util.HashSet;

//https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
	public static void main(String args[]) {
		ValidAnagram obj = new ValidAnagram();
		String s = "rat";
		String t = "cat";
		System.out.println(obj.isAnagram(s, t));
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int arr[] = new int[256];

		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)] += 1;
			arr[t.charAt(i)] -= 1;
		}

		for (int i : arr) {
			if (i != 0)
				return false;
		}
		return true;
	}
}
