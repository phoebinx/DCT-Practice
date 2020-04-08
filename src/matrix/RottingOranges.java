package matrix;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/rotting-oranges/
public class RottingOranges {
	public static void main(String args[]) {
		RottingOranges obj = new RottingOranges();
		int grid[][] = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		System.out.println(obj.orangesRotting(grid));
	}

	public int orangesRotting(int[][] grid) {
		int ans = 0;
		
	}

	public int getMaxTime(int i, int j, int[][] grid) {
	
	}

	public boolean makeRotten(int i, int j, int[][] grid) {
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 2)
			return true;
		return false;
	}
}
//you add all rotten
//then add delimiter
//then make all adjacent fresh ones rotten and add to queue
//increase time
//makes its adjacent rotten
//increase time
//bfs
//https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/