package paracticeString;
//https://www.youtube.com/watch?v=00FmUN1pkGE
//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {
	public static void main(String args[]) {
		LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();
//		String s = "ABAB";
//		int k = 2;
		String s = "AABABBA";
		int k = 1;
		System.out.println(obj.characterReplacement(s, k));
	}

	public int characterReplacement(String s, int k) {
		int start = 0, end=0;
		//maxCount maintains max frequency char in current window
		//maxLength maintains maxLength of string with longest char replacement
		int maxCount = 0, maxLength =0;
		int charCount[] = new int[26];
		for (end =0;end<s.length();end++) {
			int currentCharCount = ++charCount[s.charAt(end)-'A'];
			maxCount = Math.max(maxCount, currentCharCount);
			while  ((end-start+1)-maxCount>k) {
				charCount[s.charAt(start)-'A']--;
				start++;
			}
			maxLength = Math.max(maxLength, end-start+1);
		}
		return maxLength;
	}
}
