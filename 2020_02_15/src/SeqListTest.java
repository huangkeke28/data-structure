public class SeqListTest {
    public static void addTest() {
        SeqList seqList = new SeqList();
        seqList.add(0, 11);
        seqList.add(0, 222);
        seqList.add(0, 22222);
        seqList.add(0, 22332);
        seqList.add(0, 224442);
        seqList.display();
    }

    public static void removeTest() {
        SeqList seqList = new SeqList();
        seqList.add(0, 11);
        seqList.add(0, 131);
        seqList.add(0, 1541);
        seqList.remove(3);
        seqList.remove(2);
        seqList.display();
    }
    public static void main(String[] args) {
        //addTest();
        removeTest();
    }
}
