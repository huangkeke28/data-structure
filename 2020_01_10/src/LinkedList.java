public class LinkedList {
    //要想知道一个单链表 必须知道头节点
    private Node head = null;
    //头插
    public void addFrist(int data) {
        //根据data先创建一个结点对象
        Node node = new Node(data);
        //先判断链表是否为空
        if (head == null) {
            head = node;
            return;
        }
        //正常头插
        node.next = head;
        head = node;
        return;
    }

    public void display() {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        //链表是否为空
        if (head == null) {
            head = node;
            return;
        }
        //正常插入 先要找到尾结点
        Node tail = head;
        while(tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        return;
    }

    private int getSize() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }
    public boolean addIndex(int index, int data) {
        //在下标为index的位置插入 需要先找到他的前一个结点
        //时刻注意参数的合法性
        int size = getSize();
        if (index < 0 || index > size) {
            return false;
        }
        if (index == 0) {
            addFrist(data);
            return true;
        }
        if (index == size) {
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        Node prev = getPos(index -1);
        node.next = prev.next;
        prev.next = node;
        return true;
    }

    private Node getPos(int index){
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public boolean contains(int key) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }

    public void remove(int key) {
        //如果是头节点 特殊处理一下
        //尾结点呢？
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node prev = searchPrev(key);
        Node node = prev.next;
        prev.next = node.next;
        return;
    }
    private Node searchPrev(int key) {
        for (Node cur = head; cur != null && cur.next != null; cur = cur.next) {
            if (cur.next.data == key) {
                return cur;
            }
        }
        return null;
    }
    public void removeAllkey(int key) {
        //先处理后面的结点 最后再处理头节点
        Node prev = head;
        Node cur = prev.next;
        while (cur != null) {
            if (cur.data == key) {
                prev.next = cur.next;
                cur = prev.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        if (head.data == key) {
            head = head.next;
        }
    }
}
