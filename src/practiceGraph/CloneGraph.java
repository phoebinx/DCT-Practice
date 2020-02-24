package practiceGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/clone-graph/
//Adjacency list

public class CloneGraph {
	public class Node {
		int val;
		List<Node> neighbors;
		Node(int val){
			this.val = val;
			neighbors = new ArrayList<Node>();
		}
	}
	
	public static void main(String args[]) {
		CloneGraph cg = new CloneGraph();
		Node source = cg.buildGraph();
		cg.BFS(source);
		Node cloneSource = cg.getClone(source);
		cg.BFS(cloneSource);
	}
	
	public Node getClone(Node source) {
		HashMap<Node,Node> relation = new HashMap<>();
		Queue<Node> bfs = new LinkedList<Node>();
		relation.put(source, new Node(source.val));
		
		bfs.add(source);
		while(!bfs.isEmpty()) {
			Node og = bfs.poll();
			Node cg = relation.get(og);
			for (Node neighbor:og.neighbors) {
				if (!relation.containsKey(neighbor)) {
					Node temp = new Node(neighbor.val);
					cg.neighbors.add(temp);
					relation.put(neighbor, temp);
					bfs.add(neighbor);
				} else {
					cg.neighbors.add(relation.get(neighbor));
				}
			}
		}
		return relation.get(source);
	}
	
	public void BFS(Node source) {
		if (source != null) {
			Queue<Node> bfs = new LinkedList<Node>();
			HashSet<Node> visited = new HashSet<>();
			
			bfs.add(source);
			visited.add(source);
			while(!bfs.isEmpty()) {
				Node temp = bfs.poll();
				System.out.println(temp.val+" ");
				System.out.println(temp+" ");
				for (Node neighbor:temp.neighbors) {
					if (!visited.contains(neighbor)) {
						visited.add(neighbor);
						bfs.add(neighbor);
					}
				}
			}
			
		}
	}
	
	public Node buildGraph() {
//		Node n1 = new Node(1);
//		Node n2 = new Node(2);
//		Node n3 = new Node(3);
//		Node n4 = new Node(4);
		
//		List<Node> v = new ArrayList<>();
//		v.add(n2);
//		v.add(n4);
//		n1.neighbors=v;
//		
//		v= new ArrayList<>();
//		v.add(n1);
//		v.add(n3);
//		n2.neighbors=v;
//		
//		v= new ArrayList<>();
//		v.add(n2);
//		v.add(n4);
//		n3.neighbors=v;
//				
//		v= new ArrayList<>();
//		v.add(n1);
//		v.add(n3);
//		n4.neighbors=v;

		Node n0 = new Node(0);
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		
		List<Node> v = new ArrayList<>();
		v.add(n3);
		n2.neighbors=v;
		
		v= new ArrayList<>();
		v.add(n1);
		n3.neighbors=v;
				
		v= new ArrayList<>();
		v.add(n1);
		v.add(n0);
		n4.neighbors=v;

		v= new ArrayList<>();
		v.add(n2);
		v.add(n0);
		n5.neighbors=v;

		
		return n1;
	}
}
