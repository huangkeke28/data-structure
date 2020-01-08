public class TestLinkedList {
    public static void addTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(3);
        linkedList.addFirst(33);
        linkedList.addFirst(333);
        linkedList.display();
    }
    public static void addLastTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(6);
        linkedList.addLast(66);
        linkedList.addLast(666);
        linkedList.display();
    }
    public static void addIndexTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addIndex(0, 1);
        linkedList.addIndex(0, 11);
        linkedList.addIndex(0, 122);
        linkedList.addIndex(0, 1222);
        linkedList.display();
    }
    public static void removeTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(11);
        linkedList.addFirst(111);
        linkedList.addFirst(112);
        linkedList.addFirst(1122);
        linkedList.remove(1122);
        linkedList.display();
    }

    public static void main(String[] args) {
//        addLastTest();
//        addIndexTest();
//        removeTest();
        int[] arr = {1, 2, 3, 4};
        System.out.println(arr);
    }

}
