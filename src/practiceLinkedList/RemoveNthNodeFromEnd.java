package practiceLinkedList;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEnd {
	ListNode head;

	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}

	public static void main(String args[]) {
		RemoveNthNodeFromEnd obj = new RemoveNthNodeFromEnd();
		obj.head = obj.new ListNode(1);
		obj.head.next = obj.new ListNode(2);
		obj.head.next.next = obj.new ListNode(3);
		obj.head.next.next.next = obj.new ListNode(4);
		obj.head.next.next.next.next = obj.new ListNode(5);
		obj.printLL(obj.head);
		obj.head = obj.removeNthFromEnd(obj.head, 2);
		System.out.println();
		obj.printLL(obj.head);
	}

	public void printLL(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode first = head;
		ListNode nextNode = head;
		
		//set nextNode n times ahead of head node (2 pointer solution)
		for (int i =0;i<n;i++) 
			nextNode = nextNode.next;
		
		if (nextNode == null)
			return head;
		
		while(nextNode.next!=null) {
			first = first.next;
			nextNode= nextNode.next;
		}
		
		first.next = first.next.next;
		
		return head;
	}
}
