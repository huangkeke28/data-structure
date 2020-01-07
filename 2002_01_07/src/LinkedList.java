import com.sun.org.apache.xpath.internal.objects.XNodeSet;

public class LinkedList {
    //管理链表所有结点 只需记录头节点即可
    //初始情况下头节点head为null,此时表示空链表（不带傀儡结点）
    private Node head = null;
    public void addFirst(int data) {
        //根据data值构建一个结点对象（Node对象）
        Node node = new Node(data);
        //1.如果为空链表
        if(head == null) {
            head = node;
            return;
        }
        //2.如果不为空链表
        node.next = head;
        head = node;
    }
    public void addLast(int data) {
        //根据data值构建一个结点对象
        Node node = new Node(data);
        //1.如果为空链表
        if (head == null) {
            head = node;
            return;
        }
        //2.如果链表不为空，先要找到链表最后一个元素的值
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        //循环结束后tail对应的就是最后一个结点了
        tail.next = node;
    }
    public void display() {
        //把链表的每一个元素都打印出来
        for(Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }
    //在链表的任意位置插入
    public boolean addIndex(int index, int data) {
        //判断参数index 是否越界
        //写一个链表长度getSize的方法
        int size = getSize();
        if(index < 0 || index > size) {
            return false;
        }
        //index == 0 头插
        if(index == 0) {
            addFirst(data);
        }
        //index == size 尾插
        if(index == size) {
            addLast(data);
        }
        //中间插入
        //根据data值构建一个结点对象
        Node node = new Node(data);
        //找到index的前一个结点
        Node prev = getPrev(index - 1);
        node.next = prev.next;
        prev.next = node;
        return true;
    }
    private Node getPrev(int index) {
        Node prev = head;
        int num = 0;
        while(num < index) { // 1 2 3 4
            prev = prev.next;
            num++;
        }
        return prev;
    }
    private int getSize() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }
    public boolean contains(int key) {
        for(Node cur = head; cur != null; cur = cur.next) {
            if(cur.data == key) {
                return true;
            }
        }
        return false;
    }
    public void remove(int key) {
        //如果是头节点，需要特殊处理一下
        if(head.data == key) {
            head = head.next;
        }
        //不是头节点 需要找到他的前一个结点
        Node prev = getPos(key);
        Node node =prev.next;
        prev.next = node.next;

    }
    public Node getPos(int key) {
        for(Node cur = head; cur != null && cur.next != null; cur = cur.next) {
            if(cur.next.data == key) {
                return cur;
            }
        }
        return null;
    }
    public int size() {
        int size = 0;
        for(Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size++;
    }
    public void clear() {
        head = null;
    }



}
