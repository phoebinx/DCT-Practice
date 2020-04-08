package interview;

import java.util.ArrayList;
import java.util.List;

public class RemoveDupList {
	public static void main(String args[]) {
		int a[] = { 1, 2, 5, 5, 5 };
		int b[] = { 2, 4, 5 };
		RemoveDupList obj = new RemoveDupList();
		List<List<Integer>> list = obj.deDup(a, b);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
	}

	public List<List<Integer>> deDup(int[] a, int[] b) {
		List<List<Integer>> list = new ArrayList<>();
		list.add(util(a,b));
		list.add(util(b,a));
		return list;
	}

	public List<Integer> util(int x[], int y[]) {
		List<Integer> aList = new ArrayList<>();
		int i = 0, j = 0;
		while(y[j]<x[i])
			j++;
		while (i < x.length && j < y.length) {
			while (x[i] < y[j]) {
				aList.add(x[i]);
				i++;
			}
			if (x[i] != y[j]) {
				aList.add(x[i]);
			}
			i++;
			j++;
		}
		while (i < x.length) {
			aList.add(x[i]);
			i++;
		}

		return aList;
	}
}
