package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/search-suggestions-system/
public class SearchSuggestionSystem {
	public static void main(String args[]) {
		String products[] = { "mobile", "mouse", "moneypot", "monitor", "mousepad" };
		String searchWord = "mouse";
		SearchSuggestionSystem obj = new SearchSuggestionSystem();
		List<List<String>> suggestions = obj.suggestedProducts(products, searchWord);
		for (List<String> suggestion : suggestions)
			System.out.println(suggestion);
	}

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {
		List<List<String>> suggestions = new ArrayList<>();
		// sort product lexicographically
		Arrays.sort(products);
		int low = 0;
		int high = products.length - 1;
		int len = searchWord.length();
		int max3;
		for (int i = 0; i < len; i++) {
			while (low <= high && (products[low].length() <= i || products[low].charAt(i) != searchWord.charAt(i)))
				low++;
			while (low <= high && (products[high].length() <= i || products[high].charAt(i) != searchWord.charAt(i)))
				high--;
			max3 = Math.min(low + 3, high + 1);
			List<String> suggestion = new ArrayList<>();
			for (int j = low; j < max3; j++) {
				suggestion.add(products[j]);
			}
			suggestions.add(suggestion);
		}
		return suggestions;
	}
}

//brute force is for all products check if index of that substring
//is their and add those products but that would be super inefficient.
//you need to elliminate proucts tested in previous iteration. therefore 
//sort the array and then elliminate from front and back if character at 
//that index doesn't match. 2 pointer approach.'