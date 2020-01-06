public class LinkedList {
    //管理所有的链表结点只需记录头节点即可
    //初始情况下头节点为null，此时表示空链表（不带傀儡结点）
    private Node head = null;

    //头插法
    //1.考虑是否为空链表
    public void addFirst(int data) {
        //根据data的值，先构建一个结点对象
        Node node = new Node(data);
        //1.链表为空
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    //尾插法
    public void addLast(int data) {
        //1.根据data的值，先构建一个结点对象
        Node node = new Node(data);
        //2.考虑链表是否为空
        if (head == null) {
            head = node;
            return;
        }
        //3.链表不为空，循环找到链表的最后一个结点
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    //打印链表
    //循环遍历链表
    public void display() {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.print(cur.data + " ");
        }
        System.out.println();
    }

    public int getSize() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    public Node getPos(int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public boolean addIndex(int index, int data) {
        //考虑index是否合法
        //考虑头插或者尾插
        //中间插入
        //先写一个或许长度的方法
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
        //中间插入
        //1.先给当前要插入的元素创建一个结点
        //2.要找到前一个结点的位置
        Node node = new Node(data);
        Node prev = getPos(index - 1);
        node.next = prev.next;
        prev.next = node;
        return true;
    }

    public boolean contains(int key) {
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data == key) {
                return true;
            }
        }
        return false;
    }

    private Node searchPre(int key) {
        for (Node cur = head; cur != null && cur.next
                != null; cur = cur.next) {
            if (cur.next.data == key) {
                return cur;
            }
        }
        return null;
    }

    public void remove(int key) {
        //删除一个结点
        //首先要知道这个结点的位置
        //还要知道上一个结点和下一个结点的位置
        //你是怎么知道位置的
        //还要考虑是否为头删
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node prev = searchPre(key);
        Node toDelete = prev.next;
        prev.next = toDelete.next;

    }

    public int size() {
        int size = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }

    //写一个冒泡排序
    public void bublleSort(int arr[]) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = 0; cur < arr.length - 1 - bound; cur++) {
                if (arr[cur] > arr[cur + 1]) {//升序
                    int tmp = arr[cur + 1];
                    arr[cur + 1] = arr[cur];
                    arr[cur] = tmp;
                }
            }
        }
    }
    //写个二分法（折半查找）
    public int binarySearch(int arr[],int toFind) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > toFind) {
                right = mid - 1;
            } else if (arr[mid] < toFind) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    //逆置数组
    public void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}