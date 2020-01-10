public class LinkedListTest {
    public static void addFirstTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFrist(11);
        linkedList.addFrist(111);
        linkedList.addFrist(1111);
        linkedList.addFrist(11111);
        linkedList.display();
    }
    public static void addLastTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(1);
        linkedList.addLast(11);
        linkedList.addLast(111);
        linkedList.addLast(1111);
        linkedList.display();
    }

    public static void addIndexTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addIndex(0, 1);
        linkedList.addIndex(0, 11);
        linkedList.addIndex(0, 111);
        linkedList.addIndex(0, 1111);
        linkedList.addIndex(1, 9999);
        linkedList.display();
    }
    public static void removeTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addIndex(0, 11);
        linkedList.addIndex(0, 111);
        linkedList.addIndex(0, 1111);
        linkedList.addIndex(1, 9999);
        linkedList.remove(111);
        linkedList.display();
    }
    public static void main(String[] args) {
//        addFirstTest();
//        addLastTest();
//        addIndexTest();
        removeTest();
    }
}
