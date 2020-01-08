
public class LinkedList {
    private Node head = null;
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);//在这里 前面那个构造方法就起作用了
        //1. 判断链表是否为空
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    //写一个display方法
    public void display() {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        //如果链表为空 那么直接插就可以
        if (head == null) {
            head = node;
            return;
        }
        //如果链表不为空 那要先找到最后一个节点
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
        return;
    }
    //任意位置插入，第一个数据结点为0的下标
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        //切记！！！！！！任何时候你都要考虑参数的合法性
        //先循环遍历链表的长度
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
        //找到pos的前一个结点
        Node prev = getPos(index - 1);
        node.next = prev.next;
        prev.next = node;
        return true;
    }
    private Node getPos(int pos) {
        Node cur = head;
        for (int i = 0; i < pos; i++) {
            cur = cur.next;
        }
        return cur;
    }
    private int getSize() {
        int size = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }
    //查看包含关键字key是否在单链表中
    public boolean contains(int key) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }
    //删除第一次出现关键字为key的结点
    public void remove(int key) {
        //判断链表是否为空
        if (head.data == key) {
            head = head.next;
            return;
        }
        //先找到key的前一个结点
        Node prev = getNode(key);
        Node node = prev.next;
        prev.next = node.next;
    }
    private Node getNode(int key) {
        for (Node cur = head; cur != null && cur.next != null; cur = cur.next) {
            if (cur.next.data == key) {
                return cur;
            }
        }
        return null;
    }
    public void removeAllKey(int key) {
        Node prev = head;
        Node cur = prev.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = prev.next;
            }
        }
        if (head.data == key) {
            head = head.next;
        }
    }
    public void clear() {
        head = null;
    }
}
