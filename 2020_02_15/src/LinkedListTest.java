public class LinkedListTest {
    public static void addFirstTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(111);
        linkedList.addFirst(11331);
        linkedList.addFirst(111545);
        linkedList.display();
    }

    public static void addLastTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(222);
        linkedList.addLast(23322);
        linkedList.addLast(225552);
        linkedList.display();
    }

    public static void addIndexTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addIndex(0, 11);
        linkedList.addIndex(0, 1221);
        linkedList.addIndex(0, 14441);
        linkedList.addIndex(1, 999);
        linkedList.display();
    }

    public static void removeTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addIndex(0, 11);
        linkedList.addIndex(0, 1221);
        linkedList.addIndex(0, 14441);
        linkedList.addIndex(1, 999);
        linkedList.remove(9999);
        linkedList.display();
    }

    public static void removeAllkeyTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addIndex(0, 11);
        linkedList.addIndex(0, 1221);
        linkedList.addIndex(0, 14441);
        linkedList.addIndex(1, 3333);
        linkedList.addIndex(0, 3333);
        linkedList.removeAllkey(3333);
        linkedList.display();
    }
    public static void main(String[] args) {
//        addFirstTest();
//        addLastTest();
//        addIndexTest();
//        removeTest();
        removeAllkeyTest();
    }

}
