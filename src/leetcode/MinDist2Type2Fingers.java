package leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/contest/weekly-contest-171/problems/minimum-distance-to-type-a-word-using-two-fingers/
//https://www.youtube.com/watch?v=e69ijgCudX8
public class MinDist2Type2Fingers {
	HashMap<Character, int[]> keyBoard = new HashMap<>();
	HashMap<String, Integer> mem = new HashMap<>();
	
	String word = "HAPPY";
	public static void main(String args[]) {
		MinDist2Type2Fingers obj = new MinDist2Type2Fingers();
		//precomute map
		obj.preComputeKeyboard();
//		for (Map.Entry<Character, int[]> e: obj.keyBoard.entrySet()) {
//			System.out.println(e.getKey()+":("+e.getValue()[0]+","+e.getValue()[1]+")");
//			
//		}
		System.out.println(obj.minPath(0, Integer.MIN_VALUE, Integer.MIN_VALUE));
	}
	
	public void preComputeKeyboard() {
		for (int i = 'A'; i<='Z'; i++) {
			int arr[] = {(i-'A')/6,(i-'A')%6};
			keyBoard.put((char)i, arr);
		}
	}
	
	public int minPath(int i, int f1, int f2) {
		if (i>=word.length())
			return 0;
		if (mem.containsKey(i+"~"+f1+"~"+f2)) {
			return mem.get(i+"~"+f1+"~"+f2); 
		}
		//finger 1
		int choice1 = dist(i,f1)+minPath(i+1, i, f2);
		//finger2
		int choice2 = dist(i,f2)+minPath(i+1, f1, i);
		int res = Math.min(choice1, choice2);
		mem.put(i+"~"+f1+"~"+f2, res);
		return res;
	}
	
	public int dist(int c1, int c2) {
		if (c1==Integer.MIN_VALUE || c2==Integer.MIN_VALUE)
			return 0;
		int x1, x2, y1, y2;
		x1 = keyBoard.get(word.charAt(c1))[0];
		y1 = keyBoard.get(word.charAt(c1))[1];
		x2 = keyBoard.get(word.charAt(c2))[0];
		y2 = keyBoard.get(word.charAt(c2))[1];
		return Math.abs((x1-x2)+(y1-y2));
	}
}
