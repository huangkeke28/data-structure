public class TestSeqList {
    public static void displayTest() {
        SeqList seqList = new SeqList();
        seqList.display();
    }

    public static void addTest() {
        SeqList seqList = new SeqList();
        seqList.add(0, 11);
        seqList.add(0, 112);
        seqList.add(0, 131);
        seqList.display();
    }


    public static void main(String[] args) {
//        displayTest();
        addTest();
    }

}
