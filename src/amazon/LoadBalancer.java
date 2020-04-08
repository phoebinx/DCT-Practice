package amazon;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/discuss/interview-question/506287/
public class LoadBalancer {
	public static void main(String args[]) {
		 //int load[] = { 1, 3, 4, 2, 2, 2, 1, 1, 2 };
		//int load[] = { 1, 1, 1, 1, 1, 1 };
		 List<Integer> list = new ArrayList<>();
		 for (int i =0;i<20000;i++) {
			 if (i%2==0)
				 list.add(1);
			 else
				 list.add(2);
		 }
		 Integer [] load = list.toArray(new Integer[] {});
		LoadBalancer obj = new LoadBalancer();
		System.out.println(obj.handleLoad(load));
	}

	public boolean handleLoad(Integer load[]) {
		int sum = 0;
		for (int e : load)
			sum = sum + e;

		int l = 1;
		int r = load.length - 2;
		int sumL = load[0];
		int sumR = load[load.length - 1];

		while (l < r) {
			if (sumL == sumR) {
				if (sum - ((sumL * 2) + load[l] + load[r]) == sumL) {
					return true;
				} else {
					sumL = sumL + load[l];
					sumR = sumR + load[r];
					l = l + 1;
					r = r - 1;
				}
			} else if (sumL >= sumR) {
				sumR = sumR + load[r];
				r = r - 1;
			} else {
				sumL = sumL + load[l];
				l = l + 1;
			}
		}
		return false;
	}

}
