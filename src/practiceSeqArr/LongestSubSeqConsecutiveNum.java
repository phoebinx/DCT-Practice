package practiceSeqArr;

import java.util.Arrays;
import java.util.HashSet;

public class LongestSubSeqConsecutiveNum {
	Integer arr[] = { 2, 0, 6, 1, 5, 3, 7 };

	public static void main(String args[]) {
		LongestSubSeqConsecutiveNum obj = new LongestSubSeqConsecutiveNum();
		System.out.println(obj.getMaxLen());
	}

	public int getMaxLen() {
		HashSet<Integer> hs = new HashSet<>(Arrays.asList(this.arr));
		int count = 0, maxCount = Integer.MIN_VALUE;

		for (Integer e : arr) {
			// e is first element of subarry
			if (!hs.contains(e - 1)) {
				count = 1;
				while (hs.contains((e + count))) {
					count++;
				}
				maxCount = Math.max(maxCount, count);
			}
		}
		return maxCount;
	}
}
