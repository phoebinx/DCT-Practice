package practiceLinkedList;

import practiceLinkedList.ReverseLL.ListNode;
//https://www.youtube.com/watch?v=xRYPjDMSUFw
//https://leetcode.com/problems/reorder-list/
public class ReorderList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	ListNode head;
	ListNode head2;
	ListNode headFinal;

	public static void main(String args[]) {
		ReorderList obj = new ReorderList();
		obj.head = obj.new ListNode(1);
		obj.head.next = obj.new ListNode(2);
		obj.head.next.next = obj.new ListNode(3);
		obj.head.next.next.next = obj.new ListNode(4);
		obj.reorderList(obj.head);
		// obj.printLL(obj.head);
	}

	public void printLL(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public void reorderList(ListNode head) {
		splitList(head);
		head2 = reverseList(head2);
		mergeLists(head, head2);
		printLL(head);
	}

	public void splitList(ListNode head) {
		if (head == null || head.next == null)
			return;

		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		head2 = slow;
		prev.next = null;
	}

	public ListNode reverseList(ListNode h) {
		if (h == null || h.next == null)
			return h;

		ListNode prev, curNode, nextNode;
		prev = null;
		curNode = h;

		while (curNode != null) {
			nextNode = curNode.next;
			curNode.next = prev;
			prev = curNode;
			curNode = nextNode;
		}
		return prev;
	}

	public void mergeLists(ListNode l1, ListNode l2) {
		while (l1 != null) {
			ListNode l1_next = l1.next;
			ListNode l2_next = l2.next;
			l1.next = l2;

			if (l1.next == null)
				break;

			l2.next = l1_next;
			l1 = l1_next;
			l2 = l2_next;
		}

	}
}
