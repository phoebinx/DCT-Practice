//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
package practiceSeqArr;

public class BuySellStock {
	public static void main(String args[]) {
		BuySellStock obj = new BuySellStock();
		int arr[] = {7,6,4,3,1};
		
		System.out.println(obj.maxProfit(arr));
	}
	
	public int maxProfit(int arr[]) {
		int profit = 0, max = Integer.MIN_VALUE,start=0,min=Integer.MAX_VALUE,end=arr.length-1;
		
		while(end>start) {
			if (arr[start]<min) {
				min = arr[start];
			}
			if (arr[end]>max) {
				max = arr[end];
			}
			start++;
			end--;
		}
		return min==Integer.MAX_VALUE || max==Integer.MIN_VALUE || max<min ? 0 : max-min;
	}
}
