package leetcode.linkedlist;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(0); // Nút giả để dễ xử lý
        ListNode current = dummy;

        ListNode current1 = list1;
        ListNode current2 = list2;
        while (true) {
            if (current1 == null || current2 == null)
                break;
            if (current2.val > current1.val) {
                current.next = current1;
                current1 = current1.next;
            } else {
                current.next = current2;
                current2 = current2.next;
            }
            current = current.next;
        }

        if (current1 != null) {
            current.next = current1;
        }
        if (current2 != null) {
            current.next = current2;
        }
        return dummy.next;

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
}
