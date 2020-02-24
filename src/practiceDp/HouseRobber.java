package practiceDp;

//https://leetcode.com/problems/house-robber/
public class HouseRobber {
	int arr[] = { 2,3,2 };

	public static void main(String args[]) {
		HouseRobber obj = new HouseRobber();
		System.out.println(obj.maxMoneyCircle());
	}

	public int maxMoney() {

		int even = 0, odd = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0)
				even = even + arr[i];
			else
				odd = odd + arr[i];
		}
		return Math.max(even, odd);
	}

public int maxMoneyCircle() {
		
		int first = 0,last=0;
		int i = 0; int j =1;
		while (i<arr.length-2 && j<arr.length-1) {
			first = first + arr[i];
			last = last + arr[j];
			i+=2;
			j+=2;
		}
			
		return Math.max(first, last);
	}
}
