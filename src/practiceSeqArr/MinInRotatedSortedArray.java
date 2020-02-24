package practiceSeqArr;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinInRotatedSortedArray {
	public static void main(String args[]) {
		MinInRotatedSortedArray obj = new MinInRotatedSortedArray();
		int arr[] = {3,4,5,1,2};
		System.out.println(obj.minElement(arr,0,arr.length-1));
	}
	
	public int minElement(int [] arr,int low, int high) {
		
		if (arr[low]<arr[high])
			return arr[low];
		else if (arr[low] == arr[high])
			return arr[low];
		
		int mid = low+high/2;
		
		if(mid<high && arr[mid]>arr[mid+1])
			return arr[mid+1];
		else if (mid>low && arr[mid]>arr[mid-1])
			return arr[mid];
		else if (arr[mid]>arr[high])
			return minElement(arr,mid+1,high);
		return minElement(arr,low,mid-1);
	}
}
