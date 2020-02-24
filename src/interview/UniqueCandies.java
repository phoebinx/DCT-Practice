package interview;

import java.util.HashMap;

public class UniqueCandies {
	public static void main(String args[]) {
		UniqueCandies obj = new UniqueCandies();
		int [] T = {80, 80, 1000000000, 80, 80, 80, 80, 80, 80, 123456789};
		System.out.println(obj.solution(T));
	}
	public int solution(int[] T) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i : T) {
			if (hm.containsKey(i)) {
				hm.put(i, hm.get(i)+1);
			} else {
				hm.put(i, 1);
			}
		}
        return Math.min((T.length/2), hm.size());
    }
}
