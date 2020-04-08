package interview;

	import java.io.*;
	import java.util.*;

	/*
	# Interview question: version number comparison
	# 
	# The goal of this question is to write a function, in a language of
	# your choice, that will compare two version number strings. Version
	# number strings are strings like "0.2.3" or "2.12.4". They are strings
	# of digits separated by periods. You may assume that the strings do
	# not contain any other characters.
	# 
	# The comparison function will take 2 such strings as inputs, and
	# return an integer as the result. If the input strings are "a" and
	# "b", the function should return:
	# 
	# 1, if a > b
	# 0, if a == b
	# -1, if a < b
	# 
	# The comparison needs to be based on the version numbers. This
	# comparison is defined by considering each component integer of the
	# strings pairwise. Here are some examples:
	# 
	# 2.12 > 2.2 (because 12 > 2)
	# 1.2.3 == 1.2.3
	# 1.2.0 == 1.2
	# 1.2.0.0 == 1.2
	# 1.2.0.1 > 1.2
	# 1.2.10 < 1.2.12
	# 
	# Code below, in a language of your choice
	# (something like C, C++, Java, python or JavaScript would be good):
	*/

	/*
	 * To execute Java, please define "static void main" on a class
	 * named Solution.
	 *
	 * If you need more classes, simply define them inline.
	 */

	class compareVersions {
	  public static void main(String[] args) {
		compareVersions obj = new compareVersions();
	    String str1 = "1.2.10";
	    String str2 = "1.2.10.0.2";
	    System.out.println(obj.compare(str1, str2));
	  }
	  
	  public int compare(String str1, String str2) {
	    String x[]= removeTrailingZeros(str1.split("\\."));// 1 2 0
	    String y[]= removeTrailingZeros(str2.split("\\.")); //2 2
	    
	    int len = Math.min (x.length, y.length);
	    
	    for (int i = 0;i<len;i++) {
	      if(Integer.parseInt(x[i]) > Integer.parseInt(y[i])) {
	        return 1;
	      } else if (Integer.parseInt(x[i]) < Integer.parseInt(y[i])) {
	        return -1;
	      }
	      
	    }
	    if (x.length> y.length) {
	      return 1;
	    } else if (x.length < y.length) {
	      return -1;
	    }
	    return 0;
	  }
	  public String[] removeTrailingZeros(String[] str) {
	    
	    ArrayList<String> list = new ArrayList<>();
	    for (int i = str.length-1; i>=0;i--) {
	      if (Integer.parseInt(str[i])==0 && list.isEmpty()) {
	        continue;
	      } else {
	        list.add(str[i]);
	      }
	    }
	    Collections.reverse(list);
	    String [] strArr = list.toArray(new String[]{});
	    return strArr;
	  }
	}
