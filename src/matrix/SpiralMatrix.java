package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	//int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
	int matrix[][] = { {}};
	 List<Integer> arr= new ArrayList<>();
	public static void main(String args[]) {
		SpiralMatrix obj = new SpiralMatrix();
		obj.arr = obj.printSpiral(obj.matrix);
		for (int i : obj.arr) {
			System.out.println(i);
		}
	}

	public  List<Integer> printSpiral(int[][] matrix) {
		List<Integer> arr= new ArrayList<>();
		if (matrix.length==0)
			return arr;
		int ri = 0, rf = matrix.length - 1;
		int ci = 0, cf = matrix[0].length - 1;
		
		while (ci <= cf && ri <= rf) {
			// right
			for (int j = ci; j <= cf; j++) {
				arr.add(matrix[ri][j]);
			}
			ri = ri + 1;
			// down
			if (checkCondition(ci, cf, ri, rf)) {
				for (int i = ri; i <= rf; i++) {
					arr.add(matrix[i][cf]);
				}
				cf = cf - 1;
			} else {
				break;
			}
			// left
			if (checkCondition(ci, cf, ri, rf)) {
				for (int j = cf; j >= ci; j--) {
					arr.add(matrix[rf][j]);
				}
				rf = rf - 1;
			} else {
				break;
			}
			// up
			if (checkCondition(ci, cf, ri, rf)) {
				for (int i = rf; i >= ri; i--) {
					arr.add(matrix[i][ci]);
				}
				ci = ci + 1;
			} else {
				break;
			}
		}
		return arr;
	}

	public boolean checkCondition(int ci, int cf, int ri, int rf) {
		return ci <= cf && ri <= rf;
	}

}
