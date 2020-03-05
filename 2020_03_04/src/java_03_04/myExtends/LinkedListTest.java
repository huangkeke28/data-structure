package java_03_04.myExtends;

public class LinkedListTest {
    static class ListNode{
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    //反转一个单链表
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode Next = cur.next;
            if (Next == null) {
                head = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = Next;
        }
        return head;
    }

    public ListNode middleNode(ListNode head) {
        int size = getSize(head);
        int steps = size / 2;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    private int getSize(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
