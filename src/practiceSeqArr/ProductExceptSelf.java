package practiceSeqArr;
//https://leetcode.com/problems/product-of-array-except-self/
public class ProductExceptSelf {
	public static void main(String args[]) {
		ProductExceptSelf obj = new ProductExceptSelf();
		int arr[] = {1,2,3,4};
		int outArr[] = obj.getProductArray(arr);
		for(int j:outArr) {
			System.out.print(j+",");
		}
	}
	
	public int[] getProductArray(int[] arr) {
		if (arr.length==0) return null;
		int outArr[] = new int[arr.length];
		outArr[0]=1;
		outArr[1]=arr[0];
		for (int i = 1;i<arr.length-1;i++) {
			outArr[i+1] = outArr[i] * arr[i];
		} 
		int k =1;
		for(int j = arr.length-2;j>=0;j--) {
			k=k*arr[j+1];
			outArr[j] = outArr[j]*k;
		}
		return outArr;
	}
}
