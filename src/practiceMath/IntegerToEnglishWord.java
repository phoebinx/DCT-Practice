package practiceMath;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//https://www.youtube.com/watch?v=qwotMTggot0

//https://leetcode.com/problems/integer-to-english-words/
public class IntegerToEnglishWord {
	HashMap<Integer, String> ones = new HashMap<>();
	HashMap<Integer, String> teens = new HashMap<>();
	HashMap<Integer, String> tens = new HashMap<>();
	HashMap<Integer, String> hm = new HashMap<>();
	HashMap<Integer, String> places = new HashMap<>();

	public static void main(String args[]) {
		IntegerToEnglishWord obj = new IntegerToEnglishWord();
		obj.fillMaps();
		obj.divideAndCon(1234567891);
		obj.computeEnglish();

	}

	public void computeEnglish() {
		ArrayList<Integer> ar = new ArrayList<>(this.hm.keySet());
		StringBuilder sbFinal = new StringBuilder();
		for (int i = ar.size() - 1; i >= 0; i--) {
			StringBuilder sb = new StringBuilder();
			String str = hm.get(ar.get(i));
			switch (str.length()) {
			case 3:
				sb.append(getHundreds(Integer.parseInt(str)));
				if (sb.length()>0 ) {
					sb.append(' ');
					sb.append(places.get(ar.get(i)));
					sb.append(' ');
				}
				sbFinal.append(sb);
				break;
			case 2:
				sb.append(getTens(Integer.parseInt(str)));
				if (sb.length()>0 ) {
					sb.append(' ');
					sb.append(places.get(ar.get(i)));
					sb.append(' ');
				}
				sbFinal.append(sb);
				break;
			case 1:
				sb.append(getOnes(Integer.parseInt(str)));
				if (sb.length()>0 ) {
					sb.append(' ');
					sb.append(places.get(ar.get(i)));
					sb.append(' ');
				}
				sbFinal.append(sb);
				break;
			default:
				break;
			}
		}
		System.out.println(sbFinal.toString());
	}

	public void divideAndCon(int num) {
		// divide num in groups of 3
		String str = Integer.toString(num);
		int index = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (i - 2 >= 0) {
				hm.put(index, str.substring(i - 2, i + 1));
				index = index + 1;
				i = i - 2;
			} else if (i - 1 >= 0) {
				hm.put(index, str.substring(i - 1, i + 1));
				index = index + 1;
				i = i - 1;
			} else {
				hm.put(index, Character.toString(str.charAt(i)));
				index = index + 1;
			}
		}

		for (Map.Entry<Integer, String> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	// three digit
	public String getHundreds(int num) {
		StringBuilder str = new StringBuilder();
		str.append(ones.get(num / 100));

		if (!str.equals(null) && str.length() != 0) {
			str.append(" hundred ");
		}
		str.append(getTens(num % 100));
		return str.toString();
	}

	// two digit
	public String getTens(int num) {
		StringBuilder str = new StringBuilder();
		if (num / 10 == 1) {
			str.append(teens.get(num));
		} else {
			str.append(tens.get(num / 10));
			if (!str.equals(null) && str.length() != 0) {
				str.append(" ");
			}
			str.append(ones.get(num % 10));
		}
		return str.toString();
	}

	// one digit
	public String getOnes(int num) {
		StringBuilder str = new StringBuilder();
		str.append(ones.get(num));
		return str.toString();
	}

	public void fillMaps() {
		ones.put(0, "");
		ones.put(1, "one");
		ones.put(2, "two");
		ones.put(3, "three");
		ones.put(4, "four");
		ones.put(5, "five");
		ones.put(6, "six");
		ones.put(7, "seven");
		ones.put(8, "eight");
		ones.put(9, "nine");

		teens.put(10, "ten");
		teens.put(11, "eleven");
		teens.put(12, "twelve");
		teens.put(13, "thirteen");
		teens.put(14, "fourteen");
		teens.put(15, "fivteen");
		teens.put(16, "sixteen");
		teens.put(17, "seventeen");
		teens.put(18, "eighteen");
		teens.put(19, "nineteen");

		tens.put(0, "");
		tens.put(2, "twenty");
		tens.put(3, "thirty");
		tens.put(4, "fourty");
		tens.put(5, "fivty");
		tens.put(6, "sixty");
		tens.put(7, "seventy");
		tens.put(8, "eighty");
		tens.put(9, "ninety");

		places.put(0, "");
		places.put(1, "Thousand");
		places.put(2, "Million");
		places.put(3, "Billion");
	}
}
