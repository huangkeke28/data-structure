public class TestSeqList {
    public static void main(String[] args) {
//        SeqList seqList = new SeqList();
//        addTest();
        removeTest();
    }
    public static void addTest(){
        SeqList seqList = new SeqList();
        seqList.add(0, 1);
        seqList.add(0, 2);
        seqList.add(0, 3);
        seqList.add(0, 4);
        seqList.display();
    }
    public static void removeTest(){
        SeqList seqList = new SeqList();
        seqList.add(0, 1);
        seqList.add(0, 11);
        seqList.add(0, 111);
        seqList.add(0, 1111);
        seqList.remove(111);
        //seqList.clear();
        seqList.display();
    }
}
