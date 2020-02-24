package practiceInterval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingII {
	int[][] matrix = { { 0, 30 }, { 5, 10 }, { 9, 20 } };
	PriorityQueue<int[]> pq;
	public static void main(String args[]) {
		MeetingII obj = new MeetingII();
		Arrays.sort(obj.matrix, (int a[], int b[])-> {
			return a[0]-b[0];
		});
		obj.pq = new PriorityQueue<>((int a[], int b[])-> {
			return a[1]-b[1];
		});
		System.out.println(obj.NoOfRooms());
	}
	
	public int NoOfRooms() {
		pq.add(matrix[0]);
		for(int i=1;i<matrix.length;i++) {
			if ( matrix[i][0] >= pq.peek()[1]) {
				pq.remove();
			}
			pq.add(matrix[i]);
		}
		return pq.size();
	}
}

//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
//
//For example,
//
//Given [[0, 30],[5, 10],[15, 20]],
//return 2.
//https://www.youtube.com/watch?v=PWgFnSygweI
//For this we take a min heap (sortd on interval's end time)
//and check the root's end time which is is less then the new interval we merge both as 
//both meetings can happen in same room,
//if the end time is larger than the new interval, we insert a new node in heap as overlapping happening.
//finally size of heaps is no of rooms required.