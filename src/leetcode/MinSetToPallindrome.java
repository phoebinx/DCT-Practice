package leetcode;

//https://leetcode.com/contest/weekly-contest-170/problems/minimum-insertion-steps-to-make-a-string-palindrome/
public class MinSetToPallindrome {
	public static void main(String args[]) {
		MinSetToPallindrome obj = new MinSetToPallindrome();
		String s = "no";
		System.out.println(obj.minInsertions(s));
	}

	public int minInsertions(String s) {
		String rev = new StringBuilder(s).reverse().toString();
		int lcs = LongestCommonSubsequence(s.toCharArray(), 
				rev.toCharArray(), s.length()-1, rev.length()-1);
		System.out.println(lcs+":lcs");
		return s.length()-lcs;
	}
	
	public int LongestCommonSubsequence(char[] s1, char[] s2, int i, int j) {
		if (i<0 || j<0)
			return 0;
		
		if (s1[i] == s2[j])
			return 1+LongestCommonSubsequence(s1,s2,i-1,j-1);
		
		return Math.max(LongestCommonSubsequence(s1,s2,i,j-1), 
				LongestCommonSubsequence(s1,s2,i-1,j));
	}

}



//Longest common subsequence between str and its reverse is common charaters 
//which will be present in both, difference of str.length and longest 
//commmon subsequnce length is the extra characted needed to be added to make string a 
//pallindrome.