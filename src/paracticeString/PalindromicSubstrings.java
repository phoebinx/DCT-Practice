package paracticeString;
//https://leetcode.com/problems/palindromic-substrings/

public class PalindromicSubstrings {
	public static void main(String args[]) {
		PalindromicSubstrings obj = new PalindromicSubstrings();
		String s = "abc";
		System.out.println(obj.countSubstrings(s));
	}

	public int countSubstrings(String s) {
		int total = 0;
		if (s.length() == 0)
			return 0;

		for (int i = 0; i < s.length(); i++) {
			total = total + util(s, i, i);
			total = total + util(s, i, i + 1);
		}
		return total;
	}

	public int util(String s, int start, int end) {
		if (s == null || start > end)
			return 0;
		int count = 0;
		while (start >= 0 && end < s.length() && start <= end && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
			count = count + 1;
		}
		return count;
	}
}
