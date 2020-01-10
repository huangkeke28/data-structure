public class SeqListTest {
    public static void displayTest() {
        SeqList seqList = new SeqList();
        seqList.display();
    }

    public static void addTest() {
        SeqList seqList = new SeqList();
        seqList.add(0, 1);
        seqList.add(0, 2);
        seqList.add(0, 3);
        seqList.add(0, 4);
        seqList.display();
    }

    public static void removeTest() {
        SeqList seqList = new SeqList();
        seqList.add(0, 1);
        seqList.add(0, 11);
        seqList.add(0, 111);
        seqList.add(0, 1111);
        seqList.remove(1111);
        seqList.remove(11);
        seqList.display();
    }
    public static void main(String[] args) {
//        displayTest();
//        addTest();
        removeTest();
    }
}
