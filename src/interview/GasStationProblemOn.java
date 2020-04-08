package interview;

//https://leetcode.com/problems/gas-station/
public class GasStationProblemOn {
	public static void main(String args[]) {
		GasStationProblemOn obj = new GasStationProblemOn();
//		int gas[] = { 1, 2, 3, 4, 5 };
//		int cost[] = { 3, 4, 5, 1, 2 };
//		int gas[] = {2,3,4 };
//		int cost[] = { 3,4,3 };
//		int gas[] = { 3, 1, 1 };
//		int cost[] = { 1, 2, 2 };
//		int gas[] = { 5, 1, 2, 3, 4 };
//		int cost[] = { 4,4,1,5,1 };
//		int gas[] = { 6, 1, 4, 3, 5 };
//		int cost[] = { 3,8,2,4,2 };
		int gas[] = {1,2,3,4,3,2,4,1,5,3,2,4};
		int cost[] ={1,1,1,3,2,4,3,6,7,4,3,1};

		System.out.println(obj.canCompleteCircuit(gas, cost));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		// surplus => extra, deficit -> lack of or low
		int surplus = 0, deficit = 0;
		int start = Integer.MIN_VALUE;
		// iterate the whole array
		for (int i = 0; i < gas.length; i++) {
			surplus = surplus+gas[i]-cost[i];
			if (surplus<0) {
				start = i+1;
				deficit = deficit+surplus;
				surplus = 0;
			}
		}
//		if (start == gas.length-1) {
//			
//		}
//		System.out.println(surplus+":"+deficit);
		
		return (surplus+deficit>=0 && start!=Integer.MIN_VALUE) ? start : -1;
	}
}
//whenever petrol tank aka surplus becomes empty, change the start to the next node