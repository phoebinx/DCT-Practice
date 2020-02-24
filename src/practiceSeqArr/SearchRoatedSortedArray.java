package practiceSeqArr;

public class SearchRoatedSortedArray {
	public static void main(String args[]) {
		SearchRoatedSortedArray obj = new SearchRoatedSortedArray();
		int arr[]= {};
		int x = 3;
		System.out.println(obj.getIndex(x,arr));
	}
	
	public int getIndex(int x, int arr[]) {
		int start = this.getStart(arr, 0, arr.length-1);
		if (x==arr[start])
			return start;
		if (x>arr[start])
			return this.search(x,arr,start+1,arr.length-1);
		if (x<arr[start])
			return this.search(x, arr,0,start-1);	
		return -1;
		
	}
	
	public int search(int x,int arr[], int low, int high) {
		if (low<0)
			return -1;
		if (arr[low]==x)
			return low;
		if (arr[high] == x)
			return high;
		int mid = low+high/2;
		if (mid<high && arr[mid]<x)
			return search(x,arr,mid+1,high);
		return search(x,arr,low,mid-1);
	}
	
	public int getStart(int arr[], int low, int high) {
		if (arr[low] < arr[high])
			return low;
		if (arr[low] == arr[high])
			return low;
		int mid=low+high/2;
		
		if (mid<high && arr[mid+1]>arr[mid])
			return arr[mid+1];
		if (mid>low && arr[mid-1]>arr[mid])
			return arr[mid];
		if (arr[mid] > arr[high])
			return getStart(arr,mid+1,high);
		return getStart(arr,low,mid-1);
	}
}
