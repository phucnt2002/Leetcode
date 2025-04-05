package leetcode.linkedlist;

public class LinkedListCycleDetection {
    //Thuật toán kiểm tra vòng lặp trong danh sách liên kết sử dụng phương pháp Floyd's Cycle Detection Algorithm (Thuật toán hai con trỏ - Tortoise and Hare Algorithm).
    public boolean hasCycle(ListNode head) {
        ListNode faster = head;
        ListNode slower = head;
        while(faster!=null&& faster.next!=null){
            faster = faster.next.next;
            slower = faster.next;
            if(faster == slower)
                return true;
        }
        return false;

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
