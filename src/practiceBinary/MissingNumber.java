package practiceBinary;
//https://leetcode.com/problems/missing-number/
public class MissingNumber {
	public static void main(String args[]) {
		MissingNumber obj = new MissingNumber();
		int arr[] = {3,0,1};
		System.out.println(obj.getMissingNumber(arr));
	}
	
	
	public int getMissingNumber(int arr[]) {
		int n = arr.length;
		int x1=0, x2=0;
		//XOR or arr elements
		for (int i:arr)
			x1^=i;
		
		//XOR of n+1 elements
		for (int i = 1;i<=arr.length;i++)
			x2^=i;
		return x1^x2;
	}
}
//The idea is xor of element with itself is 0, therefore taking all the 
//elements XOR and XOR with all but missing element XOR will give missing element
//https://www.youtube.com/watch?v=lBk6fVhuCyw
//O(n)
//can be done by subtracting each array element from the sum n(n+1)/2, but possibility of sum exceedint the int limit.
