package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalRouters {
	int n;
	int id;
	int[] low, ids; // low is for low link values
	boolean[] visited;
	List<List<Integer>> graph;

	CriticalRouters(List<List<Integer>> graph, int n) {
		if (graph == null || n <= 0 || graph.size() != n)
			throw new IllegalArgumentException();
		this.graph = graph;
		this.n = n;
	}

	// Returns a list of list of nodes indicating which nodes form bridges
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		id = 0;
		low = new int[n];// low link values
		ids = new int[n]; // Node ids
		visited = new boolean[n];

		List<List<Integer>> bridges = new ArrayList<>();

		// Finds all bridges in the graph accross various connected components;
		for (int i = 0; i < n; i++) {
			if (!visited[i])
				dfs(i, -1, bridges);
		}
		return bridges;
	}

	public void dfs(int at, int parent, List<List<Integer>> bridges) {
		visited[at] = true;
		low[at] = ids[at] = ++id;

		// for every neighbor of at
		for (Integer to : graph.get(at)) {
			if (to==parent) continue; //makes the graph directed, can't go back.
			if (!visited[to]) {
				dfs(to, at, bridges);
				// here low is low of to as to is where it came from, after call back
				low[at] = Math.min(low[at], low[to]);

				// brigde condition
				if (ids[at] < low[to]) {
					ArrayList<Integer> bridge = new ArrayList<>();
					bridge.add(at);
					bridge.add(to);
					bridges.add(bridge);
				}
			} else {
				// here low is id of the node it reaches
				low[at] = Math.min(low[at], ids[to]); //id not low coz we are not doing other dfs at this point, so we cant assume we can reach the low node of this node. 
			}
		}

	}

	public static void main(String args[]) {
		int n = 9;
		int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 2, 5 }, { 5, 6 }, { 6, 7 },
				{ 7, 8 }, { 8, 5 } };
		List<List<Integer>> graph = CreateGraph(n);
		addEdge(graph, connections);

		CriticalRouters obj = new CriticalRouters(graph, n);
		List<List<Integer>> criticalConnections = obj.criticalConnections(obj.n, obj.graph);
		for (List<Integer> list : criticalConnections) {
			System.out.println(list.get(0) + " " + list.get(1));
		}
	}

	public static List<List<Integer>> CreateGraph(int n) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		return graph;
	}

	public static void addEdge(List<List<Integer>> graph, int[][] connections) {
		for (int i = 0; i < connections.length; i++) {
			graph.get(connections[i][0]).add(connections[i][1]);
			graph.get(connections[i][1]).add(connections[i][0]);
		}
	}
}

//low link values -> lowest id that can be reached from this node.
//ids is to track id of each node, ids are assigned to nodes while doing the depth first traversal.
//the condition to find a bridge -> if (id[at) < low[to)) -> means that if the smallest node the destination 
//node can go to is more than the source node, that means the destination node cannot come
// back to the source node if either was removed, thus this is a bridge.
//Articulation points are nodes which when removed makes the graph unconnected.
// one of the nodes of the bridge will always be an articulation pount but there
// can exist another articulation point where there is no bridge , its


//   1   4
//   |\ /|
//   | 2 |
//   |/ \|
//   3   5
   
   // there is no bridge but 2 is articulatioon point.
   //removing the node which starts a cycle in the graph will also coz disconnction.
   //
   
//   
//   1  
//   |\ 
//   | 2
//   |/ 
//   3  
//   
   //2 is not atuculation point as althiugh it formas a cycle, it has only one outgoing edge.

//https://www.youtube.com/watch?v=aZXi1unBdJA
//https://www.youtube.com/watch?v=V6kRqdtM_Uk <-code>