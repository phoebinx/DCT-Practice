package practiceSeqArr;

//https://leetcode.com/problems/container-with-most-water/
public class maxContainer {
	public static void main(String args[]) {
		maxContainer obj = new maxContainer();
		int arr[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(obj.maxArea(arr));
	}

	public int maxArea(int arr[]) {
		int start = 0, end = arr.length - 1, area = Integer.MIN_VALUE, maxArea = Integer.MIN_VALUE;
		while (start < end) {
			area = Math.min(arr[start], arr[end]) * (end - start);
			maxArea = Math.max(maxArea, area);
			if(arr[start]>arr[end])
				end--;
			start++;
		}
		return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
	}
}
