package practiceLinkedList;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLL {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
	ListNode head;
	
	public static void main(String args[]) {
		ReverseLL obj = new ReverseLL();
		obj.head = obj.new ListNode(1);
		obj.head.next =  obj.new ListNode(2);
		obj.head.next.next =  obj.new ListNode(3);
		obj.head.next.next.next =  obj.new ListNode(4);
		obj.head.next.next.next.next =  obj.new ListNode(5);
		obj.printLL(obj.head);
		//obj.head = obj.reverseList(obj.head);
		obj.head = obj.reverseListRec(obj.head, null);
		System.out.println();
		obj.printLL(obj.head);
	}
	
	public void printLL(ListNode node) {
		while(node!=null) {
			System.out.println(node.val);
			node=node.next;
		}
	}
	
	public ListNode reverseListRec(ListNode head, ListNode prev) {
		ListNode finalHead=null;
		if (head.next != null) {
			finalHead = reverseListRec(head.next, head);
		} else {
			finalHead = head;
		}
	
		head.next = prev;
		return finalHead;
	}
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next==null)
			return head;
		
		ListNode node = head, prev=null, temp;
		while(node!=null) {
			temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
		}
		return prev;
	}
}
