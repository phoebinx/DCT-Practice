package amazon;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/discuss/interview-question/411357/
public class ZombieInMatrix {
	int maxHours = 0;

	public static void main(String args[]) {
		ZombieInMatrix obj = new ZombieInMatrix();
		int[][] matrix = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		obj.getHours(matrix);
		System.out.println(obj.maxHours);
	}

	public void getHours(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0)
					calculateMaxDistance(i, j, matrix);
			}
		}
	}

	public void calculateMaxDistance(int i, int j, int[][] matrix) {
		if (i==2 && j==2)
			System.out.println("here");
		int max = 0;
		int x[] = { 0, 0, -1, 1 };
		int y[] = { -1, 1, 0, 0 };
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {});
		while (i < matrix.length && j < matrix[i].length) {
			for (int k = 0; k < 4; k++) {
				if (isZombie(i + x[k], j + y[k], matrix)) {
					max = max + 1;
					maxHours = Math.max(maxHours, max);
					return;
				} else {
					que.add(new int[] {i+x[k],j+y[k]});
				}
			}
			que.add(new int[] {});
			if (que.peek().length==0) {
				max = max+1;
				que.poll();
			}
			i = que.peek()[0];
			j = que.peek()[1];
			
			que.poll();
		}
	}

	public boolean isZombie(int i, int j, int[][] matrix) {
		if (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length && matrix[i][j] == 1)
			return true;
		return false;
	}

}
