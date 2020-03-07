package ListTest;



public class LinkedListTest {
    static class ListNode {
        public int val;
        public ListNode next;

        //构造方法
        public ListNode(int val) {
            this.val = val;
        }
    }

    //1. 删除链表中等于给定值 **val** 的所有节点
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    //2. 反转一个单链表。
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                head = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return head;
    }

    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
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
        for (ListNode cur = head; cur != null; cur = cur.next) {
            count++;
        }
        return count;
    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //4. 输入一个链表，输出该链表中倒数第k个结点
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = getSize(head);
        if (k <= 0 || k > size) {
            return null;
        }
        int steps = size - k;
        ListNode cur = head;
        for (int i = 0; i < size - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //5. 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                newTail.next = new ListNode(cur1.val);
                newTail = newTail.next;
                cur1 = cur1.next;
            } else {
                newTail.next = new ListNode(cur2.val);
                newTail = newTail.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            newTail.next = cur2;
        } else {
            newTail.next = cur1;
        }
        return newHead.next;
    }

    //6. 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(ListNode pHead, int x) {
        ListNode newHead1 = new ListNode(-1);
        ListNode newHead2 = new ListNode(-1);
        ListNode tail1 = newHead1;
        ListNode tail2 = newHead2;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.val < x) {
                tail1.next = new ListNode(cur.val);
                tail1 = tail1.next;
                cur = cur.next;
            } else {
                tail2.next =  new ListNode(cur.val);
                tail2 = tail2.next;
                cur = cur.next;
            }
        }
        tail1.next = newHead2.next;
        return newHead1.next;
    }

    //7. 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
    public ListNode deleteDuplication(ListNode head) {
        ListNode cur = head;
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tail.next = new ListNode(cur.val);
                tail = tail.next;
                cur = cur.next;
            }

        }
        return newHead.next;
    }

    //8. 链表的回文结构
    //思路：1.将链表的元素放到数组里 逆置数组 依次比较
    //2.把链表复制一份 得到的链表再逆置一下 依次比较
    //3. a.先找到链表的中间结点
    //b. 逆置后半部分链表
    //c. 依次比较
    public boolean chkPalindrome(ListNode A) {
        int size = getSize(A);
        ListNode cur = A;
        for (int i = 0; i < size / 2; i++) {
            cur = cur.next;
        }
        //逆置这个链表
        ListNode pre = null;
        ListNode newHead = new ListNode(-1);
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                newHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        while (A != null && newHead != null) {
            if (A.val == newHead.val) {
                A = A.next;
                newHead = newHead.next;
            } else {
                return false;
            }
        }
        return true;
    }

    //9. 输入两个链表，找出它们的第一个公共结点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getSize(headA);
        int sizeB = getSize(headB);
        if (sizeA < sizeB) {
            for (int i = 0; i < sizeB - sizeA; i++) {
                headB = headB.next;
            }
        } else {
            for (int i = 0; i < sizeA - sizeB; i++) {
                headA = headA.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    //10. 给定一个链表，判断链表中是否有环。
    public boolean hasCycle(ListNode head) {
        //快慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public ListNode detectCycle(ListNode head) {
        //思路 从头节点和快慢指针的相遇点一起走相同步就是
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode cur1 = fast;
        ListNode cur2 = head;
        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public ListNode FindKthToTail2(ListNode head, int k) {
        int size = getSize(head);
        if (head == null) {
            return null;
        }
        if (k <= 0 || k > size){
            return null;
        }
        int steps = size - k;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        //拼接两个有序链表
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                tail.next = cur1;
                tail = tail.next;
                cur1 = cur1.next;
            } else {
                tail.next = cur2;
                tail = tail.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 == null) {
            tail.next = cur2;
        } else {
            tail.next = cur1;
        }
        return newHead.next;
    }
}
