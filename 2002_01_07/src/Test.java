import java.util.Arrays;

public class Test {
    public static void addFistTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(122);
        linkedList.addFirst(125);
        linkedList.addFirst(13);
        linkedList.addFirst(1);
        linkedList.display();
        //1 13 125 122
    }
    public static void addLastTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(34);
        linkedList.addLast(134);
        linkedList.addLast(1134);
        linkedList.display();
        //34 134 1134
    }
    public static void addIndexTest() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(34);
        linkedList.addLast(134);
        linkedList.addLast(11344);
        linkedList.addLast(1134);
        linkedList.addIndex(3, 999);
        linkedList.remove(134);
        //System.out.println(linkedList.contains(134));
        linkedList.clear();
        linkedList.display();
        //System.out.println(linkedList.size());
    }

    public static void displayTest() {
        SeqList seqList = new SeqList();
        seqList.disPlay();
    }
    public static void addTest(){
        SeqList seqList = new SeqList();
        seqList.add(0, 1);
        seqList.add(0, 2);
        seqList.add(0, 13);
        seqList.add(0, 155);
        seqList.add(2, 155);
        seqList.disPlay();
        //System.out.println(seqList.contains(2222));
      //  System.out.println(seqList.search(13));

    }
    public static void main(String[] args) {
        //addFistTest();
        //addLastTest();
        //addIndexTest();
        //addTest();
        int[] arr = {11, 33, 44, 33, 4, 5, 66};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void bubbleSort(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = 0; cur < arr.length - 1 - bound; cur++) {
                if (arr[cur] > arr[cur + 1]) {
                    int tmp = arr[cur];
                    arr[cur] = arr[cur + 1];
                    arr[cur + 1] = tmp;
                }
            }
        }
    }
}
