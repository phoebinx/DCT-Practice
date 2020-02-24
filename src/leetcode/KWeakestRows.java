package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/contest/weekly-contest-174/problems/the-k-weakest-rows-in-a-matrix/
public class KWeakestRows {
	public static void main(String args[]) {
		KWeakestRows obj = new KWeakestRows();
//		int mat[][] = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
//		int k = 3;
		int mat[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
		int k = 2;
		int arr[] = obj.kWeakestRows(mat, k);

		for (int i : arr) {
			System.out.println(i);
		}
	}

	public int[] kWeakestRows(int[][] mat, int k) {
		int arr[] = new int[k];
		HashMap<Integer, Integer> hm = new HashMap<>();
		int count;
		for (int i = 0; i < mat.length; i++) {
			count = 0;
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1)
					count++;
				else
					break;
			}
			hm.put(i, count);
		}
		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			list.add(entry);
		}

		Collections.sort(list, (Map.Entry<Integer, Integer> hm1, Map.Entry<Integer, Integer> hm2) -> {
			if (hm1.getValue() == hm2.getValue()) {
				return hm1.getKey() - hm2.getKey();
			}
			return hm1.getValue() - hm2.getValue();
		});

		for (int i = 0; i < k; i++) {
			arr[i] = list.get(i).getKey();
		}
		return arr;
	}
}
