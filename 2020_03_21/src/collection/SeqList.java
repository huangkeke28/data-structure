package collection;


import org.omg.CORBA.Object;

public class SeqList<E> {
    private E[] data = (E[])new Object[100];
    private int size = 0;
    //泛型编程类似于"模板"  E这样的泛型参数是不能被直接实例化的（当前这个E是啥类型 你不知道）
    public E get(int index) {
        return data[index];
    }

    public void add(E element) {
        data[size] = element;
        size++;
    }

    public static void main(String[] args) {
        SeqList<String> seqList = new SeqList<>();
        seqList.add("AAAA");
        seqList.add("BBBB");
        seqList.add("xxxxxxxx");
        String string = (String)seqList.get(0);
        String string1 = seqList.get(1);
        //泛型因为的背景 写一个类活着方法就能同时支持多种类型的对象
        //所谓的泛型其实就是从语法层面上对 Object进行了简单的包装 可以帮用户自动进行类型检查
        SeqList<Animal> animalSeqList = new SeqList<>();
        animalSeqList.add(new Animal());
        animalSeqList.add(new Animal());
        Animal animal = animalSeqList.get(0);
        SeqList<Integer> seqList1 = new SeqList<>();
        Integer num = new Integer(10);
        Integer num3 = 10; //自动装箱
        Integer num2 = Integer.valueOf(10);
        //int = > Integer 装箱

        //Integer = > int 拆箱
        num2 = seqList1.get(0);
        int val = num2; //自动拆箱
        int vakk = num.intValue(); //手动拆箱
        seqList1.add(num);
    }
}
