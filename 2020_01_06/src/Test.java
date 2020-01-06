import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
//        SeqList seqList = new SeqList();
////        removeTest();
//        LinkedList linkedList = new LinkedList();
//        addFirst();
        LinkedList linkedList = new LinkedList();
        int[] arr = {11, 3, 5, 6, 222, 666};
        linkedList.bublleSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void addFirst() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(33);
        linkedList.addFirst(66);
        linkedList.addFirst(99);
        linkedList.addLast(100);
        linkedList.addIndex(2, 9999);
        linkedList.display();


    }
    public static void addTest() {
        SeqList seqList = new SeqList();
        seqList.add(0, 1);
        seqList.add(0, 2);
        seqList.add(0, 3);
        seqList.add(0, 4);
        seqList.display();
    }
    public static void containsTest(){
        SeqList seqList = new SeqList();
        seqList.add(0, 100);
        seqList.add(0, 200);
        seqList.add(0, 300);
        seqList.add(0, 400);
        System.out.println(seqList.contains(100));
    }
    public static void searchTest(){
        SeqList seqList = new SeqList();
        seqList.add(0, 100);
        seqList.add(0, 200);
        seqList.add(0, 300);
        seqList.add(0, 400);
        System.out.println(seqList.search(100));
    }
    public static void removeTest() {
        SeqList seqList = new SeqList();
        seqList.add(0, 100);
        seqList.add(0, 200);
        seqList.add(0, 300);
        seqList.add(0, 400);
        seqList.remove(200);
        seqList.display();
    }
}
