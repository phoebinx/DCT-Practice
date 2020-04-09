package amazon;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/partition-labels/
public class PartitionLabel {
	public static void main(String args[]) {
		String S = "ababcbacadefegdehijhklij";
		PartitionLabel obj = new PartitionLabel();
		System.out.println(obj.partitionLabels(S));
	}

	public List<Integer> partitionLabels(String S) {
		int lastIndex []= new int[26];
		List<Integer> result = new ArrayList<>();
		//record last index of all letters
		for (int i = 0; i< S.length();i++) {
			lastIndex[S.charAt(i)-'a'] = i;
		}
		
		//find partition windows
		int start = 0;
		int end = 0;
		for (int i = 0;i<S.length();i++) {
			end = Math.max(end, lastIndex[S.charAt(i)-'a']);
			if (i==end) {
				result.add(end-start+1);
				start = end+1;
			}
		}
		return result;
	}
}
