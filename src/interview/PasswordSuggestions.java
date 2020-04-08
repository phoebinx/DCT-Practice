package interview;

import java.util.HashMap;
import java.util.List;
import java.util.*;

public class PasswordSuggestions {
	private static HashMap<Character, Character> replacements = new HashMap<Character, Character>() {
		{
			put('a', '@');
			put('i', '!');
			put('e', '3');
			put('o', '0');
			put('s', '$');
		}
	};

	public static void main(String args[]) {
		System.out.println(generate("password"));
	}

	public static List<String> generate(String password) {
		List<String> list = new ArrayList<>();
		util(password, 0, list, false);
		System.out.println(list.size());
		return list;
	}

	public static void util(String password, int i, List<String> list, boolean hasReplaced) {
		if (i == password.length()) {
			if (hasReplaced)
				list.add(password);
			return;
		}
		if (replacements.containsKey(password.charAt(i))) {
			String str1 = password.substring(0, i);
			String str2 = String.valueOf(replacements.get(password.charAt(i)));
			String str3 = password.substring(i + 1);
			util(str1 + str2 + str3, i + 1, list, hasReplaced || true);
		}
		util(password, i + 1, list, hasReplaced || false);
	}
}
