package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/reorder-data-in-log-files/
public class ReorderDatainLogFiles {
	public static void main(String args[]) {
		ReorderDatainLogFiles obj = new ReorderDatainLogFiles();
//		String[] logs = { "dig1 8 1 5 1", "let1 art can",
//				"dig2 3 6", "let2 own kit dig", "let3 art zero" };
//		String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
		String logs[] = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
		String [] op = obj.reorderLogFiles(logs);
		for (String o : op) {
			System.out.println(o);
		}
	}

	public String[] reorderLogFiles(String[] logs) {
		List<String> digits = new ArrayList<>();
		List<String> letters = new ArrayList<>();
		
		for (int i = 0;i<logs.length;i++) {
			String [] logSplit = logs[i].split(" ");
			int logBegin = logSplit[0].length()+1;
			if (Character.isDigit(logs[i].substring(logBegin).charAt(0)))
				digits.add(logs[i]);
			else {
				letters.add(logs[i]);
			}
		}
	
		letters.sort((String str1,String str2)-> {
			String [] str1Arr = str1.split(" ");
			String [] str2Arr = str2.split(" ");
			int str1Begin = str1Arr[0].length()+1;
			int str2Begin = str2Arr[0].length()+1;
			String str1Firstword = str1.substring(str1Begin);
			String str2Firstword = str2.substring(str2Begin);
			if (str1Firstword.equalsIgnoreCase(str2Firstword))
				return str1Arr[0].compareToIgnoreCase(str2Arr[0]); //compare identifiers
			else 
				return str1Firstword.compareTo(str2Firstword);
		});
		
		letters.addAll(digits);
		return letters.toArray(new String[] {});
	}
}
