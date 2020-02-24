package practiceSeqArr;
//https://leetcode.com/problems/maximum-product-subarray/
public class MaxProductSubArray {
	public static void main(String args[]) {
		MaxProductSubArray obj = new MaxProductSubArray();
		int arr[]= {-2,0,-1};
		System.out.println(obj.maxProduct(arr));
	}
	
	public int maxProduct(int arr[]) {
		//int pro=Integer.MIN_VALUE, maxPro=Integer.MIN_VALUE;
		int pro=0, maxPro=0;
		for (int i: arr) {
			pro = Math.max(i, i*pro);
			maxPro = Math.max(pro, maxPro);
		}
		return maxPro;
	}
}
