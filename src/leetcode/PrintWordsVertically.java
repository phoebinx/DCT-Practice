package leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/contest/weekly-contest-172/problems/print-words-vertically/
public class PrintWordsVertically {
	public static void main(String args[]) {
		PrintWordsVertically obj = new PrintWordsVertically();
		String s = "CONTEST IS COMING";
		// obj.printVertically(s);
		for (String str : obj.printVertically(s)) {
			System.out.println(str);
		}
	}

	public List<String> printVertically(String s) {
		List<String> list = new ArrayList<String>();
		String arr[] = s.split(" ");
		if (arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				int j = 0;
				while ((int) arr[i].length() > j) { // not null
					if (list.size() <= j)
						list.add(j, String.valueOf(arr[i].charAt(j)));
					else {
						String s2 = list.get(j) + String.valueOf(arr[i].charAt(j));
						list.remove(j);
						list.add(j, s2);
					}
					j++;
				}
				while (j != list.size()) {
					String s2 = list.get(j) + " ";
					list.remove(j);
					list.add(j, s2);
					j++;
				}
				
				if (i==arr.length-1 && j>arr[i].length()) {
					for (int k = 0; k<list.size();k++) {
						String r = list.get(k);
						int len = r.length()-1;
						while((r.charAt(len) == ' ') && len>=0) {
							len=len-1;
						}
						list.remove(k);
						list.add(k, r.substring(0,len+1));
					}
				}
			}
		}
		
			
		return list;
	}
}
