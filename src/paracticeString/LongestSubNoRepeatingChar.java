package paracticeString;

import java.util.HashMap;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubNoRepeatingChar {
	public static void main(String args[]) {
		LongestSubNoRepeatingChar obj = new LongestSubNoRepeatingChar();
		String str = "abcdaef";
		System.out.println(obj.lengthOfLongestSubstring(str));
	}

	public int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> visited = new HashMap<>();
		int maxLen = 0;
		for (int start = 0, end = 0; end < s.length(); end++) {
			if (visited.containsKey(s.charAt(end))) {
				start = Math.max(visited.get(s.charAt(end)) + 1, start);
			}
			maxLen = Math.max(maxLen, end - start + 1);
			visited.put(s.charAt(end), end);

		}
		return maxLen;
	}
}

//it is solved by sliding windwo techniue, two pointers, start and end.
//a hashmap recordi g the char visited and its location.
//start is updated to poistion of that char which was repeated +1.
//if you just increment start when repeated char is found then it not necessary that you are oiting the repeated char thus you must take start to next or repeating char. 
//You should set start to max of repeating char and start coz it is possible that start is already ahead of repeating char.
