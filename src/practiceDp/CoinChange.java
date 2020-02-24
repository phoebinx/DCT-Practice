package practiceDp;

//https://leetcode.com/problems/coin-change/
public class CoinChange {
	int coins[] = { 5, 2, 1};

	public static void main(String args[]) {
		CoinChange obj = new CoinChange();
		int amt = 11;
		System.out.println(obj.minQ(amt, 0));
	}

	public int minQ(int remVal, int index) {
		if (remVal == 0)
			return 0;
		if (index > coins.length - 1)
			return -1;
		
		
		if (index == coins.length - 1) 
			if(remVal % coins[index] == 0)
				return remVal / coins[index];
			else
				return -1;
		
		
		int d = (int) Math.floor(remVal / coins[index]);
		int min = Integer.MAX_VALUE;
		for (int i = d; i >=0; i--) {
			int result = minQ(remVal-(i*coins[index]), index+1);
			if (result != -1)
				min = Math.min(result+i, min);
		}
		if (min == Integer.MAX_VALUE) {
			return -1;
		}

		return min;
	}

}
