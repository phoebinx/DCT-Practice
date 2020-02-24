package practiceSeqArr;
//https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
//O(n)
public class LongestSubstringKUniqueChar {
	char[] str;
	int k;

	public static void main(String args[]) {
		LongestSubstringKUniqueChar obj = new LongestSubstringKUniqueChar();
		obj.str = "aabacbebebe".toCharArray();
		obj.k = 3;
		System.out.println(obj.longestStringWithUniqueChars());
	}

	public String longestStringWithUniqueChars() {
		int arr[] = new int[128];
		int start = 0, end = 0, counter = 0, maxLength = Integer.MIN_VALUE, maxStart = 0;

		while (end < str.length) {
			if (arr[str[end]] == 0) {
				counter++;
			}
			arr[str[end]]++;
			end++;
			// counter==k
			while (counter > k) {
				arr[str[start]]--;
				if (arr[str[start]] == 0)
					counter--;
				start++;
			}
			if (maxLength < end - start) {
				maxLength = end - start;
				maxStart = start;
			}

		}
		return maxLength == Integer.MIN_VALUE ? "" : new String(str).substring(maxStart, maxStart + maxLength);
	}

}
