package amazon;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/
public class RottingOrganges {
	public static void main(String args[]) {
		RottingOrganges obj = new RottingOrganges();
		// int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
		// int grid[][] = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
		int grid[][] = { { 0, 2,2 } };
		System.out.println(obj.orangesRotting(grid));
	}

	public int orangesRotting(int[][] grid) {
		Queue<Integer[]> Q = new LinkedList<>();
		int minMinutes = -1;
		int x[] = { 1, -1, 0, 0 };
		int y[] = { 0, 0, 1, -1 };
		// add rotten oranges
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					Q.add(new Integer[] { i, j });
				}
			}
		}
		if (Q.isEmpty())
			minMinutes = 0;

		while (!Q.isEmpty()) {
			int size = Q.size();
			for (int i = 0; i <size; i++) {
				Integer[] currentElement = Q.poll();
				for (int k = 0; k < 4; k++) {
					if (isFresh(currentElement[0] + x[k], currentElement[1] + y[k], grid)) {
						grid[currentElement[0] + x[k]][currentElement[1] + y[k]] = 2;
						Q.add(new Integer[] { currentElement[0] + x[k], currentElement[1] + y[k] });
					}
				}
			}
			minMinutes = minMinutes + 1;
		}

		return checkFresh(grid) == true ? -1 : minMinutes;
	}

	public boolean isFresh(int i, int j, int[][] grid) {
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1)
			return true;
		return false;
	}

	public boolean checkFresh(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					return true;
			}
		}
		return false;
	}
}
