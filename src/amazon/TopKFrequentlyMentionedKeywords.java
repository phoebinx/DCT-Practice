package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentlyMentionedKeywords {
	HashMap<String, Integer> hm = new HashMap<>();

	public static void main(String args[]) {
		TopKFrequentlyMentionedKeywords obj = new TopKFrequentlyMentionedKeywords();
//		String keywords[] = { "anacell", "cetracular", "betacellular" };
//		String reviews[] = { "Anacell provides the best services in the city", "betacellular has awesome services",
//				"Best services provided by anacell, everyone should use anacell" };
		String[] keywords = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
		String[] reviews = { "I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular." };
		int k = 2;
		obj.populateHashMap(keywords, reviews);
		List<String> topKList = obj.getKFrequentKeywords(k);
		for (String str : topKList) {
			System.out.print(str + " ");
		}
	}

	public void populateHashMap(String keywords[], String reviews[]) {
		for (String keyword : keywords) {
			hm.put(keyword.toLowerCase(), 0);
		}

		for (String review : reviews) {
			for (String key : review.split(" ")) {
				key = key.toLowerCase();
				if (hm.containsKey(key))
					hm.put(key, hm.get(key) + 1);
			}
		}

		for (Map.Entry<String, Integer> entry : hm.entrySet())
			System.out.println(entry.getKey() + " " + entry.getValue());
	}

	public List<String> getKFrequentKeywords(int k) {
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
			if (e1.getValue() == e2.getValue())
				return e1.getKey().compareToIgnoreCase(e2.getKey());
			return e1.getValue() - e2.getValue();
		});

		for (Map.Entry<String, Integer> entry : hm.entrySet()) {
			pq.offer(entry);
			while (pq.size() > k) {
				pq.poll();
			}
		}

		List<String> result = new ArrayList<>();
		while (!pq.isEmpty()) {
			result.add(pq.poll().getKey());
		}
		Collections.reverse(result);
		return result;
	}

}
