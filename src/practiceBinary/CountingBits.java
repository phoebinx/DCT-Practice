package practiceBinary;
//https://leetcode.com/problems/counting-bits/
public class CountingBits {
	int i = 100000000; 
	int arr[] = new int[i+1];
	public static void main(String args[]) {
		CountingBits obj = new CountingBits();
		
		long ts1 = System.nanoTime();
		int[] bc = obj.getBitCount();
		long ts2 = System.nanoTime();
		int[] bc2 = obj.getBitCountBrianKarnighan();
		long ts3 = System.nanoTime();
		
		
		System.out.println("ts: " + (ts2-ts1)/10000000);
//		for (int i:bc)
//			System.out.print(i+" ");
		System.out.println("\nts2: " + (ts3-ts2)/10000000);
//		for (int i:bc2)
//			System.out.print(i+" ");
	}
	
	public int[] getBitCount() {
		arr[0] = 0;
		arr[1] = 1;
		int j = 2;
		while (j<=this.i) {
			arr[j] = arr[j/2]+j%2;
			j++;
		}
		return arr;
	}
	
	public int[] getBitCountBrianKarnighan() {
		arr[0]=0;
		arr[1]=1;
		int j = 2;
		while (j<=this.i) {
			arr[j] = arr[(j&(j-1))]+1;
			j++;
		}
		return arr;
	}
	
	
}
