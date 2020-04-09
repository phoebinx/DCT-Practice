package amazon;

import java.util.ArrayList;
import java.util.List;

public class CriticalRouterArticulationPoint {
	int[] low, ids; // low is for low link values
	int n, id, rootNodeOutcomingEdgeCount;
	boolean solved;
	boolean[] visited,isArticulationPoint;
	List<List<Integer>> graph;

	CriticalRouterArticulationPoint(List<List<Integer>> graph, int n) {
		if (graph == null || n <= 0 || graph.size() != n)
			throw new IllegalArgumentException();
		this.graph = graph;
		this.n = n;
	}
	
	 // Returns the indexes for all articulation points in the graph even if the
	  // graph is not fully connected.
	  public boolean[] findArticulationPoints() {
	    if (solved) return isArticulationPoint;

	    id = 0;
	    low = new int[n]; // Low link values
	    ids = new int[n]; // Nodes ids
	    visited = new boolean[n];
	    isArticulationPoint = new boolean[n];

	    for (int i = 0; i < n; i++) {
	      if (!visited[i]) {
	        rootNodeOutcomingEdgeCount = 0;
	        dfs(i, i, -1);
	        isArticulationPoint[i] = (rootNodeOutcomingEdgeCount > 1);
	      }
	    }

	    solved = true;
	    return isArticulationPoint;
	  }
	  

	
	public void dfs(int root, int at, int parent) {
		if (parent == root) rootNodeOutcomingEdgeCount++;

	    visited[at] = true;
	    low[at] = ids[at] = id++;

	    List<Integer> edges = graph.get(at);
	    for (Integer to : edges) {
	      if (to == parent) continue;
	      if (!visited[to]) {
	        dfs(root, to, at);
	        low[at] = Math.min(low[at], low[to]);
	        if (ids[at] <= low[to]) {
	          isArticulationPoint[at] = true;
	        }
	      } else {
	        low[at] =  Math.min(low[at], ids[to]);
	      }
	    }
	  }


	public static void main(String args[]) {
		int n = 9;
		int[][] connections = { { 0, 1 }, { 1, 2 } };
		List<List<Integer>> graph = CreateGraph(n);
		addEdge(graph, connections);

		CriticalRouterArticulationPoint obj = new CriticalRouterArticulationPoint(graph, n);
		boolean[] isArticulationPoint = obj.findArticulationPoints();
		for (int i = 0; i < n; i++)
		      if (isArticulationPoint[i]) System.out.println("Node "+i+"is an articulation");
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

// low link values -> lowest id that can be reached from this node.
// ids is to track id of each node, ids are assigned to nodes while doing the
// depth first traversal.
// the condition to find a bridge -> if (id[at) < low[to)) -> means that if the
// smallest node the destination
// node can go to is more than the source node, that means the destination node
// cannot come
// back to the source node if either was removed, thus this is a bridge.
// Articulation points are nodes which when removed makes the graph unconnected.
// one of the nodes of the bridge will always be an articulation pount but there
// can exist another articulation point where there is no bridge , its

// 1 4
// |\ /|
// | 2 |
// |/ \|
// 3 5

// there is no bridge but 2 is articulatioon point.
// removing the node which starts a cycle in the graph will also coz
// disconnction.
//

//
// 1
// |\
// | 2
// |/
// 3
//
// 2 is not atuculation point as althiugh it formas a cycle, it has only one
// outgoing edge.

// https://www.youtube.com/watch?v=aZXi1unBdJA
// https://www.youtube.com/watch?v=V6kRqdtM_Uk <-code>
