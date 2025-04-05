package leetcode.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode previousNode = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previousNode;
            previousNode = current;
            current = temp;
        }
        return previousNode;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }
}
