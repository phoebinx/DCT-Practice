//https://leetcode.com/problems/minimum-window-substring/
//https://leetcode.com/problems/minimum-window-substring/discuss/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems
package practiceSeqArr;

public class MinWindowSubstring {
	char[] s;
	char[] t;

	public static void main(String args[]) {
		MinWindowSubstring obj = new MinWindowSubstring();
		obj.s = "ADOBECODEBANC".toCharArray();
		obj.t = "ABC".toCharArray();
		;
		System.out.println(obj.minWondow());
	}

	public String minWondow() {
		int start = 0, end = 0, minStart = 0, minDist = Integer.MAX_VALUE, counter = t.length;
		;
		int arr[] = new int[128];
		for (char c : t)
			arr[c]++;

		while (end < s.length) {
			if (arr[s[end]] > 0)
				// found t char (arr) in s, reduce remaining elements from counter and remove
				counter--;
			arr[s[end]]--;
			end++;

			while (counter == 0) {
				if (end - start < minDist) {
					minDist = end - start;
					minStart = start;
				}
				// increasing start pointer and adding it to the arr, since prev start is
				// removed.
				arr[s[start]]++;
				if (arr[s[start]] > 0)
					counter++;
				start++;
			}

		}
				
		return minDist == Integer.MAX_VALUE ? "" : new String(s).substring(minStart, minStart + minDist);
	}

}
//arr saves number of occurances of characters in current window. between start and end.
//counter saves those characters that are part of substring, if arr[c] > 0 that means that it is part of substring.

// find a substring which will havppen if counter is 0
//while couter is 0, increase start and add arr[start[c]]] value as you are removing it from window.
//if you get arr[start][c] value ? 0, you have removed the char of substring so you need to increase the counter.
