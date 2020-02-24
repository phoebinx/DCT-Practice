package paracticeString;
//https://www.youtube.com/watch?v=y2BD4MJqV20&t=748s
//https://leetcode.com/problems/longest-palindromic-substring/
public class LongfestPallindromicSubSring {
	public static void main(String args[]) {
		LongfestPallindromicSubSring obj = new LongfestPallindromicSubSring();
		String s = "cbbd";
		System.out.println(obj.longestPalindrome(s));

	}

	public String longestPalindrome(String s) {
		if (s.length()==0)
			return "";
					
		int len1, len2;
		int start = 0, end = 0;
		for (int i =0;i<s.length()-1;i++) {
			len1 = util(s,i,i);
			len2 = util(s,i,i+1);
			if ((end-start) < Math.max(len1, len2)) {
				if (len1>len2) {
					start = i - ((len1-1)/2);
					end = i + (len1/2);
					System.out.println(i);
				} else {
					start = i - ((len2-1)/2);
					end = i + (len2/2);
					System.out.println(i);
				}
			}
		}
		return s.substring(start, end+1);
	}

	// returns length of the pallindrome
	public int util(String s, int start, int end) {
		
		if (s==null || start >end)
			return 0;
		
		if (s.charAt(start) == s.charAt(end)) {
			while (start > 0 && end < s.length()-1 && start <= end && s.charAt(start-1) == s.charAt(end+1)) {
				start--;
				end++;
			}
		} else {
			return 0;
		}
		return end - start + 1;
	}
}
