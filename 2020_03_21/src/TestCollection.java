import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class TestCollection {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        //这个代码进行向上转型 实际new的对象是ArrayList，使用Collection类型来保存这个对象
        //应用"泛型"语法
        //写一个类/方法，让这个方法和类可以同时支持多种不同类型的数据
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        collection.add("我");
        collection.add("爱");
        collection.add("中国");
        System.out.println(collection.size());
        System.out.println(collection.isEmpty());
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));
        for(String s : collection) {
            System.out.println(s);
        }
        System.out.println(collection.contains("我"));
        System.out.println(collection.remove("我"));
        for (String s : collection) {
            System.out.println(s);
        }
        collection.clear();
        System.out.println(collection.isEmpty());
        System.out.println(collection.size());

    }
}
