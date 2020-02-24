package leetcode;

import java.util.ArrayList;

//https://leetcode.com/contest/weekly-contest-172/problems/maximum-69-number/
public class Max69Num {
	public static void main(String args[]) {
		Max69Num obj = new Max69Num();
		System.out.println(obj.maximum69Number(9999));
	}

	public int maximum69Number(int num) {
		StringBuilder str1 = new StringBuilder();
		String str = Integer.toString(num);
		boolean flag = false;
		for (int i =0;i<str.length();i++) {
			if (!flag && str.charAt(i) == '6') {
				str1.append("9");
				flag = true;
			} else {
				str1.append(str.charAt(i));
			}
				
		}
		return Integer.parseInt(str1.toString());
	}
}
