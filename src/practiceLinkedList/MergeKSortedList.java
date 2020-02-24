package practiceLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import practiceLinkedList.ReverseLL.ListNode;

//https://leetcode.com/problems/merge-k-sorted-lists/
public class MergeKSortedList {
	ListNode head1;
	ListNode head2;
	ListNode head3;

	class PQNode {
		int outerI;
		int innerJ;
		int val;
		PQNode(int val, int outerI, int innerJ) {
			this.outerI = outerI;
			this.innerJ = innerJ;
			this.val = val;
		}
	}
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String args[]) {
		MergeKSortedList obj = new MergeKSortedList();
		obj.head1 = obj.new ListNode(1);
		obj.head1.next = obj.new ListNode(4);
		obj.head1.next.next = obj.new ListNode(5);
		obj.head2 = obj.new ListNode(1);
		obj.head2.next = obj.new ListNode(3);
		obj.head2.next.next = obj.new ListNode(4);
		obj.head3 = obj.new ListNode(2);
		obj.head3.next = obj.new ListNode(5);
		List<ListNode> lists = new LinkedList<>();
		lists.add(obj.head1);
		lists.add(obj.head2);
		lists.add(obj.head3);
		ListNode newHead = obj.mergeKLists(lists);
		obj.printLL(newHead);
	}

	public ListNode mergeKLists(List<ListNode> lists) {
		List<ListNode> finalList = new LinkedList<>();
		PriorityQueue<PQNode> pq = new PriorityQueue<>((PQNode n1, PQNode n2)-> {
			return n1.val-n2.val;
		});
		//put the first item of all lists in pq
		for(int i = 0;i<lists.size();i++) {
			ListNode node = lists.get(i);
			pq.add(new PQNode(node.val,i,0));
		}
		
		while(!pq.isEmpty()) {
			PQNode node = pq.poll();
			finalList.add(new ListNode(node.val));
			if (lists.get(node.outerI).l)
		}
		
		return finalList.get(0);
	}
	
	public void printLL(ListNode node) {
		while(node!=null) {
			System.out.println(node.val);
			node=node.next;
		}
	}
}
