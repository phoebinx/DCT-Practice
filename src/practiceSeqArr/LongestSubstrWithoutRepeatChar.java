package practiceSeqArr;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstrWithoutRepeatChar {
	char str[];

	public static void main(String args[]) {
		LongestSubstrWithoutRepeatChar obj = new LongestSubstrWithoutRepeatChar();
		obj.str= "pwwkew".toCharArray();
		System.out.println(obj.longestSubStr());
	}

	public String longestSubStr() {
		int start = 0, end = 0, maxStart = 0, maxLength = Integer.MIN_VALUE;
		int arr[] = new int[128];

		while (end < str.length) {
			while (arr[str[end]] != 0) {
				arr[str[start]]--;
				start++;
			}
			if (arr[str[end]] == 0) {
				arr[str[end]]++;
				end++;
			}
			if (maxLength < end - start) {
				maxLength = end - start;
				maxStart = start;
			}
		}
		return maxLength==Integer.MIN_VALUE?"": new String(str).substring(maxStart, maxStart+maxLength);
	}
}
