class Node {
    public int data;
    public Node next = null;

    //写一个data的构造方法
    public Node(int data) {
        this.data = data;
    }
}

public class LinkedList {
    //知道链表的头节点就可以找到整个链表
    private Node head = null;

    //头插
    public void addFirst(int data) {
        //根据data创建一个结点对象
        Node node = new Node(data);
        //判断链表是否为非空链表
        if (head == null) {
            head = node;
            return;
        }
        //链表不为空
        node.next = head;
        head = node;
        return;
    }

    //打印链表
    public void display() {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    //尾插
    public void addLast(int data) {
        //先创建结点对象
        Node node = new Node(data);
        //判断链表是否为空
        if (head == null) {
            head = node;
            return;
        }
        //链表不为空
        //需要找到最后一个结点
        Node pre = head;
        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = node;
        return;
    }

    //在任意位置插入
    public boolean addIndex(int index, int data) {
        int size = getSize();
        //检查参数的有效性
        if (index < 0 || index > size) {
            return false;
        }
        //头插
        if (index == 0) {
            addFirst(data);
            return true;
        }
        //尾插
        if (index == size) {
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        //普通位置插入
        //找到index前一个位置的结点
        Node pre = getPre(index);
        node.next = pre.next;
        pre.next = node;
        return true;
    }

    //获取链表长度
    public int getSize() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    //获取index位置前一个位置的结点
    public Node getPre(int index) {
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //查找是否包含关键字key在单链表中
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
        //思路怎么一下子给断了呢 第一次出现关键字为key的结点 先找到他的前一个结点
        //判断头节点是否为key
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node pre = getPreNode(key);
        if (pre == null) {
            return;
        }
        Node cur = pre.next;
        pre.next = cur.next;
        return;
    }

    //找到key关键字的前一个结点
    public Node getPreNode(int key) {
        for (Node cur = head; cur != null&& cur.next != null; cur = cur.next) {
            if (cur.next.data == key) {
                return cur;
            }
        }
        return null;
    }

    //删除所有值为key的结点
    public void removeAllkey(int key) {
        //先不管头节点，创建两个引用对象
        Node pre = head;
        Node cur = pre.next;
        while (cur != null) {
            if (cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        //最后判断头节点
        if (head.data == key) {
            head = head.next;
            return;
        }
    }

    public int size() {
        int size = 0;
        for (Node cur = head; cur.next != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public void clear() {
        head = null;
    }
}
