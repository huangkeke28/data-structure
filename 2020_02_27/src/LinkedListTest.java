import com.sun.xml.internal.ws.api.server.EndpointReferenceExtensionContributor;
import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    //static 修饰的内部类是为了这个类和外部类相关，而不是和对象相关
    //后续如果要创建内部类的实例的话 就不需要依赖于外部类的实例
    static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    //删除链表中等于给定值 val 的所有节点
    public ListNode removeElements(ListNode head, int val) {
        //先判断链表是否为空
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode toRemove = head.next;
        while (toRemove != null) {
            if (toRemove.val == val) {
                pre.next = toRemove.next;
                toRemove = pre.next;
            } else {
                pre = toRemove;
                toRemove = toRemove.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
    //2. 反转一个单链表
    public ListNode reverseList(ListNode head) {
        //链表为空这种情况一定要考虑到
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode Next = head.next;
        while (cur != null) {
            cur.next = pre ;
            if (Next == null) {
              head = cur;
              break;
            }
            pre = cur;
            cur = Next;
            Next = Next.next;
        }
        return head;
    }
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode Next = head.next;
        while (cur != null) {
            //核心操作
            cur.next = pre;
            if (Next == null) {
                head = cur;
                break;
            }
            pre = cur;
            cur = Next;
            Next = Next.next;
        }
        return head;
    }

    // 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。[
    public ListNode middleNode (ListNode head) {
        if (head == null) {
            return null;
        }
        int size = getSize(head);
        ListNode cur = head;
        for (int i = 0; i < size / 2; i++) {
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

    //输入一个链表，输出该链表中倒数第k个结点
    public ListNode FindKthToTail(ListNode head, int k) {
        int size = getSize(head);
        if ( k < 1 || k > size) {
            return null;
        }
        ListNode cur = head;
        for (int i = 0; i < size - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
            if (cur1 == null) {
                tail.next = cur2;
            } else {
                tail.next = cur1;
            }
        }
        return newHead.next;
    }
    // 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode newHead1 = new ListNode(-1);
        ListNode tail1 = newHead1;
        ListNode newHead2 = new ListNode(-1);
        ListNode tail2 = newHead2;
        for(; cur != null; cur = cur.next) {
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
        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;
        ListNode cur = head;
        for(;cur != null && cur.next != null; cur = cur.next) {
            if (cur.val != cur.next.val) {
                tail.next = cur;
                tail = tail.next;
            } else {
                ListNode Next = cur.next;
                while (cur.val == Next.next.val) {
                    Next = Next.next;
                }
                cur = Next.next;
            }
        }

        return newHead.next;
    }
    public static void main(String[] args) {
        ListNode s1 = new ListNode(1);
        ListNode s2 = new ListNode(3);
        ListNode s3 = new ListNode(1);
        ListNode s4 = new ListNode(6);
        ListNode s5 = new ListNode(7);
        s1.next = s2;
        s2.next = s3;
        s3.next = s4;
        s4.next = s5;
        s5.next = null;
        LinkedListTest linkedListTest = new LinkedListTest();
        //ListNode cur = linkedListTest.removeElements(s1, 1);
        ListNode cur = linkedListTest.reverseList2(s1);
        while(cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
