package practiceSeqArr;
//https://leetcode.com/problems/maximum-subarray/
public class MaxSubArray {
	public static void main(String args[]) {
		MaxSubArray obj = new MaxSubArray();
		int [] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(obj.maxSum(arr));
	}
	
	public int maxSum(int arr[]) {
		int start = 0, end=0, sum=0,maxSum=0;
		for (int i=1;i<arr.length;i++) {
			sum = Math.max(sum+arr[i], arr[i]);
			maxSum=Math.max(sum, maxSum);
		}
		return maxSum;
	}

}
