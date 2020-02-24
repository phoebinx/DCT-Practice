package practiceDp;

//https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
public class KnapSack {

	int val[] = { 60, 100, 120, 100 };
	int wt[] = { 10, 20, 30, 20 };
	int totWt = 50;
	int mem[][] = new int[totWt + 1][val.length];

	public static void main(String args[]) {
		long startTime = System.nanoTime();

		KnapSack obj = new KnapSack();
		System.out.println(obj.maxWt(obj.totWt, obj.val.length - 1));

		long endTime = System.nanoTime();
		System.out.println("Took " + (endTime - startTime) + " ns");
	}

	public int maxWt(int remWt, int remCnt) {

		if (remWt == 0 || remCnt == -1)
			return 0;
		
		if (mem[remWt][remCnt] != 0) {
			System.out.println(":**");
			return mem[remWt][remCnt];
		}

		int i = val.length - 1 - remCnt;

		if (wt[i] > remWt)
			return maxWt(remWt, remCnt - 1);

		mem[remWt][remCnt] = Math.max(maxWt(remWt - wt[i], remCnt - 1) + val[i], maxWt(remWt, remCnt - 1));
		return mem[remWt][remCnt];

	}
}
