package paracticeString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.geeksforgeeks.org/find-if-string-is-k-palindrome-or-not/
public class KPallindrome {
	public static void  main(String args[]) {
		KPallindrome obj = new KPallindrome();
//		String s = "abrarbra";
//		int k = 1;
		String s = "abcdcba";
		int k = 2;
		System.out.println(obj.isKPallindrome(s,k));
	}

	private boolean isKPallindrome(String s, int k) {
		int start = 0, end = s.length()-1;
		while (start <=end  && k>=0) {
			if (s.charAt(start) != s.charAt(end)) {
				k=k-1;//1 char
				if (k<0) return false;
				if (s.charAt(start+1) == s.charAt(end)) {
					if (isKPallindrome(s.substring(start+1,end+1),k) == true) return true;
				} if (s.charAt(start) == s.charAt(end-1)) {
					if (isKPallindrome(s.substring(start,end),k) == true) return true;
				} 
				k=k-1;//2 char
			}
			start = start+1;
			end = end-1;
		}
		return k>=0?true:false;
	}
	
	
}
