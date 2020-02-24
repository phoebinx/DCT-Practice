package leetcode;

import java.util.HashMap;

public class DecryptStr {

	HashMap<Character, Character> decode = new HashMap<>();
	HashMap<String,Character> decodeHash = new HashMap<>();

	public static void main(String args[]) {
		DecryptStr obj = new DecryptStr();
		System.out.println(obj.freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
	}

	public String freqAlphabets(String s) {
		fillMapping();
		StringBuilder op = new StringBuilder();

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == '#') {
				op.append(decodeHash(s.substring(i - 2, i + 1)));
				i = i - 2;
			} else {
				op.append(decode(s.charAt(i)));
			}
		}
		return op.reverse().toString();
	}

	public void fillMapping() {
		for (int i = 1; i < 10; i++) {
			decode.put( Integer.toString(i).charAt(0), (char) (96 + i));
		}
		for (int j = 10; j < 27; j++) {
			decodeHash.put((Integer.toString(j) + '#'), (char) (96 + j));
		}

	}

	public char decodeHash(String str) {
		return decodeHash.get(str);
	}

	public char decode(char c) {
		return decode.get(c);
	}

}
