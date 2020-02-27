import com.sun.org.apache.xml.internal.dtm.ref.DTMAxisIterNodeList;

import javax.swing.plaf.IconUIResource;

public class LinkedList {
    static class Node{
        public int data;
        public Node next = null;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    public void display() {
        Node cur = head;
        for (; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void addLast (int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        return;
    }

    public boolean addIndex(int index, int data) {
        int size = getSize();
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == size) {
            addLast(data);
            return true;
        }
        Node pre = getPos(index);
        Node node = new Node(data);
        pre.next = node;
        node.next = pre.next;
        return true;
    }
    private int getSize() {
        int count = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            count++;
        }
        return count;
    }
    private Node getPos(int index) {
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public boolean contains(int key) {
        Node cur = head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void remove(int key) {
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node pre = getPre(key);
        Node cur = pre.next;
        pre.next = cur.next;
    }
    private Node getPre(int key) {
        for (Node cur = head; cur != null && cur.next != null; cur = cur.next) {
            if (cur.next.data == key) {
                return cur;
            }
        }
        return null;
    }


    public void clear() {
        head = null;
    }
}
