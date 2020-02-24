package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//https://leetcode.com/contest/weekly-contest-170/problems/get-watched-videos-by-your-friends/
public class GetWatchedVideosYourFriends {

	public static void main(String args[]) {
		GetWatchedVideosYourFriends obj = new GetWatchedVideosYourFriends();
		int k = 1;
		int friendId = 0;
		char watchedMovie[][] = { { 'A', 'B' }, { 'C' }, { 'B', 'C' }, { 'D' } };
		int friends[][] = { { 1, 2 }, { 0, 3 }, { 0, 3 }, { 1, 2 } };

		ArrayList<Integer> kFriends = obj.kLevelFriends(k, friends, friendId);
		System.out.println("friends at level "+k+":"+kFriends);
		
		Collections.addAll(kFriends, 1, 2);

		HashMap<Character, Integer> hm = new HashMap<>();

		for (int friend : kFriends) {
			for (char movie : watchedMovie[friend]) {
				if (hm.containsKey(movie))
					hm.put(movie, hm.get(movie) + 1);
				else
					hm.put(movie, 1);
			}
		}

		System.out.println(hm);
		for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + " :" + entry.getValue());
		}
	}

	public ArrayList<Integer> kLevelFriends(int k, int[][] friends, int friendId) {
		ArrayList<Integer> kFriends = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(friendId);
		HashSet<Integer> visited = new HashSet<>();

		// dfs starting from friendId
		dfsUtil(visited, friendId, friends, k, kFriends);
		return kFriends;
	}

	public void dfsUtil(HashSet<Integer> visited, int i, int[][] friends, int k, ArrayList<Integer> kFriends ) {
		visited.add(i);
		if (k == 0 & !visited.contains(i)) {
			kFriends.add(i);
		}
		for (int friend : friends[i]) {
			if (!visited.contains(friend) && k > 0)
				dfsUtil(visited, friend, friends, k - 1, kFriends);
		}
	}

	public List<Map.Entry<Character, Integer>> sortedMovieList(HashMap<Character, Integer> hm) {
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(hm.entrySet());
		Collections.sort(list, (e1, e2) -> {
			if (e1.getValue() != e2.getValue()) // different frequencies, ascending
				return e1.getValue().compareTo(e2.getValue());
			else // Alphabetically
				return e1.getKey().compareTo(e2.getKey());

		});
		return list;
	}
}

//https://www.youtube.com/watch?v=u4LHrR6UD_Y
//the logic is very simple
//Part 1:
//	find k level friends:
//		friends 2d array is a graph with every internal array as an adj list to vertex i.
//		If we do k traversal of BFS starting from given friendId, we can find friends at level k.
//		After we get a list of friends, we get movies of every friend from watchedMovies and put it
//		in the hashmap with key as movie and value and count of occurance.
//		
//Part 2:
//	arrange movies in increasing order/alphabeticall if freq is same
//		for this we put the hashmap in an arraylist and sort the list using a custom
//		comparator which first sorts based of freq, if equal the alphabatically.
