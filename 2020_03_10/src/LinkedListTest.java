public class LinkedListTest {

    static class ListNode {
        public int val;
        public ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partation(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }
        ListNode newHead1 = new ListNode(-1);
        ListNode newHead2 = new ListNode(-1);
        ListNode tail1 = newHead1;
        ListNode tail2 = newHead2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                tail1.next = new ListNode(cur.val);
                tail1 = tail1.next;
                cur = cur.next;
            } else {
                tail2.next = new ListNode(cur.val);
                tail2 = tail2.next;
                cur = cur.next;
            }
        }
        tail1.next = newHead2.next;
        return newHead1.next;
    }

    public boolean chkPalindrom(ListNode head) {
        int size = getSize(head);
        int steps = size / 2;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        ListNode prev = null;
        ListNode newHead = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        ListNode s1 = head;
        ListNode s2 = newHead;
        while (s1 != null && s2 != null) {
            if (s1.val == s2.val) {
                s1 = s1.next;
                s2 = s2.next;
            } else {
                return false;
            }
        }
        return true;
    }
    public int getSize(ListNode head) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
