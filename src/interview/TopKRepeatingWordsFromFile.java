package interview;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopKRepeatingWordsFromFile {
	HashMap<String, Integer> hm = new HashMap<>();

	public static void main(String args[]) {
		TopKRepeatingWordsFromFile obj = new TopKRepeatingWordsFromFile();
		String fileName = ("/Users/komal/Documents/test/fileReat.txt");
		int k = 2;
		obj.processFile(fileName);
		List<String> output = obj.topKWords(k);
		for (String str: output) {
			System.out.println(str);
		}
	}
	
	
	public List<String> topKWords(int k) {
		List<String> output = new ArrayList<String>();
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2)-> {
			return e1.getValue() - e2.getValue();
		});
		
		for (Map.Entry<String, Integer> entry:hm.entrySet()) {
			pq.add(entry);
			if (pq.size()>k)
				pq.poll();
		}
		
		while(pq.size()>0) {
			output.add(pq.poll().getKey());
		}
		Collections.reverse(output);
		return output;
	}
	public void processFile(String fileName) {
		File f1 = new File(fileName);
		if (f1.exists()) {
			try {
				Scanner myReader = new Scanner(f1);
				while (myReader.hasNext()) {
					String key = myReader.next();
					if (hm.containsKey(key)) {
						hm.put(key, hm.get(key) + 1);
					} else {
						hm.put(key, 1);
					}
				}
				myReader.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
//		for(Map.Entry<String, Integer> entry: hm.entrySet()) {
//			System.out.println(entry.getKey()+":"+entry.getValue());
//		}
	}
}
