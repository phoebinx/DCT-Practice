package interview;

import java.io.*;
import java.util.*;

class GasAndCost {
	public static void main(String[] args) {
		GasAndCost obj = new GasAndCost();
		// int [] gas = {1,2,3,4,5};
		// int [] cost = {3,4,5,1,2};
		// int [] gas = {1,2,3,4,5};
		// int [] cost = {3,4,5,5,12};
		int[] gas = { 2, 2, 3, 4, 5 };
		int[] cost = { 1, 4, 5, 10, 5 };
		System.out.println(obj.util(gas, cost));
	}

	public int util(int[] gas, int[] cost) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < gas.length; i++) {
			max = Math.max(max, traverse(gas, cost, i));
		}
		return max == Integer.MIN_VALUE ? -1 : max;

	}

	public int traverse(int[] gas, int[] cost, int start) {
		int end = Integer.MIN_VALUE;
		if (start > 0) {
			end = start - 1;
		} else if (start == 0) {
			end = gas.length - 1;
		} else {
			return -1;
		}

		int count = 0;
		int len = gas.length - 1;
		if (start > end) {
			while (end != start) {
				count = count + gas[start] - cost[start];
				if (count < 0) {
					return -1;
				}
				if (start == len) {
					start = -1;
				}

				start = start + 1;
			}
		} else {// normal traversal
			while (start <= end) {
				count = count + gas[start] - cost[start];
				if (count < 0) {
					return -1;
				}
				start = start + 1;
			}
		}

		return start >= len ? 0 : start;
	}
}

/*
 * To execute Java, please define "static void main" on a class named Solution.
 *
 * If you need more classes, simply define them inline.
 * 
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once in the clockwise direction, otherwise return -1.
 * 
 * gas = [1,2,3,4,5] cost = [3,4,5,1,2]
 * 
 * index = 3 -1
 */
// start = 4
