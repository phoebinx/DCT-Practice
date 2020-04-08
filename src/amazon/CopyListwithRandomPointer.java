package amazon;

import java.util.HashMap;

public class CopyListwithRandomPointer {
	Node head;

	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public static void main(String args[]) {
		CopyListwithRandomPointer obj = new CopyListwithRandomPointer();
		obj.head = obj.new Node(7);
		obj.head.next = obj.new Node(13);
		obj.head.next.next = obj.new Node(11);
		obj.head.next.next.next = obj.new Node(10);
		obj.head.next.next.next.next = obj.new Node(1);
		obj.head.next.random = obj.head;
		obj.head.next.next.random = obj.head.next.next.next.next;
		obj.head.next.next.next.random = obj.head.next.next;
		obj.head.next.next.next.next.random = obj.head;
		Node newHead = obj.copyRandomList(obj.head);
	}

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		HashMap<Node, Node> map = new HashMap<>();
		Node orignal = head;
		Node copy = new Node(head.val);
		map.put(head,copy);
		Node next = null;

		while (orignal != null) {
			if (orignal.random != null) {
				if (map.containsKey(orignal.random)) {
					copy.random = map.get(orignal.random);
				} else {
					copy.random = new Node(orignal.random.val);
					map.put(orignal.random, copy.random);
				}
			}

			orignal = orignal.next;
			if (orignal == null)
				break;

			if (map.containsKey(orignal)) {
				next = map.get(orignal);
			} else {
				next = new Node(orignal.val);
				map.put(orignal, next);
			}
			copy.next = next;
			copy = next;
		}

		return map.get(head);
	}
}
