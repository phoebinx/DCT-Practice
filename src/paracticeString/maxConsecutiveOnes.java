package paracticeString;

//https://leetcode.com/problems/max-consecutive-ones-iii/
public class maxConsecutiveOnes {
	public static void main(String args[]) {
		maxConsecutiveOnes obj = new maxConsecutiveOnes();
//		int[] A = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
//		int K = 2;
//		int [] A= {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
//		int K = 3;
		int []A = {0,0,0,1};
		int K = 4;
		System.out.println(obj.longestOnes(A, K));
	}

	public int longestOnes(int[] A, int K) {
		int maxLen = 0;
		int start = 0, end = 0;
		while (end < A.length) {
			if (A[end] == 0)
				K--;
			if (K<0) {
				maxLen = Math.max(maxLen, end - start);
				while (A[start] != 0)
					start++;
				start++;
				K++;
			} else {
				maxLen = Math.max(maxLen, end - start+1);
			}
			end++;
		}
		return maxLen;
	}
}
