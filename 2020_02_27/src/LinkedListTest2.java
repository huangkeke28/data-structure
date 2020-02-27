public class LinkedListTest2 {
    public static void addFirstTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(21);
        linkedList.addFirst(133);
        linkedList.display();
    }

    public static void addLastTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(11);
        linkedList.addLast(131);
        linkedList.addLast(1155);
        linkedList.display();
    }
    public static void main(String[] args) {
//        addFirstTest();
        addLastTest();
    }
}
