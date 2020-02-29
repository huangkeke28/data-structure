package ListNodeTest;

import com.sun.javafx.geom.BaseBounds;

import javax.xml.soap.Node;

public class Solution {
    static class ListNode{
        public int val;
        public ListNode next = null;

        public ListNode(int data) {
            this.val = data;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        //判断链表是否为空
        if (head == null) {
            return null;
        }
        //创建两个引用依次扫描链表
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

    //2. 反转一个单链表
    public ListNode reverseList(ListNode head) {
        //判断链表是否为空
        if (head == null) {
            return null;
        }
        //若链表中只有一个元素，无需反转，直接返回头
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
            //核心操作
            cur.next = prev;
            //更新指向
            prev = cur;
            cur = Next;
        }
        return head;
    }

    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点
    public ListNode middleNode(ListNode head) {
        //判断链表是否为空
        if (head == null) {
            return null;
        }
        //如果节点个数为奇数个 中位数刚好是中间节点
        //如果节点个数为偶数个 第二个中间节点 刚好是他的中位数
        int steps = getSize(head);
        ListNode cur = head;
        for (int i = 0; i < steps / 2; i++) {
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

    //4. 输入一个链表，输出该链表中倒数第k个结点
    public ListNode findKthToTail(ListNode head, int k) {
        //检查参数的合法性
        if (head == null) {// 1 2  3
            return null;
        }
        int size = getSize(head);
        if (k <= 0 || k > size) {
            return null;
        }
        //倒数第k个 也就是整数第 size - k 个
        ListNode cur = head;
        for (int i = 0; i < size - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //5. 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //判断链表是否为空
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //创建一个新的头节点
        ListNode newHead = new ListNode(-1);
        //记录尾部节点
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

    //6. 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 。
    public ListNode partition(ListNode pHead, int x) {
        //思路：创建两个新的头结点 一个保存小于x的节点 另一个保存大于x的节点 再将两个节点连接起来
        if (pHead == null) {
            return null;

        }
        ListNode newHead1 = new ListNode(-1);
        ListNode tail1 = newHead1;
        ListNode newHead2 = new ListNode(-1);
        ListNode tail2 = newHead2;
        for (ListNode cur = pHead; cur != null; cur = cur.next) {
            if (cur.val < x) {
                tail1.next = new ListNode(cur.val);
                tail1 = tail1.next;
            } else {
                tail2.next = new ListNode(cur.val);
                tail2 = tail2.next;
            }
        }
        tail1.next = newHead2.next;
        return newHead1.next;
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
    public ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }
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

    //链表的回文结构
    public Boolean chkPalindrome(ListNode A) {
        int steps = getSize(A);
        //找到链表的中间节点 反转后半部分
        //反转后半部分
        ListNode B = A;
        for (int i = 0; i < steps / 2; i++) {
            B = B.next;
        }
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode Next = cur.next;
            if (Next == null) {
                B = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = Next;
        }
        while (B != null) {
            if (A.val != B.val) {
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }

    //9. 输入两个链表，找出它们的第一个公共结点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = getSize(headA);
        int size2 = getSize(headB);
        if (size1 > size2) {
            int offset = size1 - size2;
            for (int i = 0; i < offset; i++) {
                headA = headA.next;
            }
        } else {
            int offset = size2 - size1;
            for (int i = 0; i < offset; i++) {
                headB = headB.next;
            }
        }
        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    //10. 给定一个链表，判断链表中是否有环
    //使用快慢指针的方法
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        //假如有环，使用快慢指针的方法，找到他们的相遇点
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
        ListNode cur1 = head;
        ListNode cur2 = fast;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}

