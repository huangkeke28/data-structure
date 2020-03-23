package collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest<E> {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("C");
        list.add("C++");
        list.add("Java");
        list.add("Python");
        System.out.println(list);
        System.out.println(list.get(0));
        System.out.println(list.set(0, "PHP"));
        System.out.println(list);
        for (String s : list) {
            System.out.println(s);
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.subList(1, 3));
        List<String> list1 = new ArrayList<>(list);
        System.out.println(list1);
        list.set(0, "C#");
        System.out.println(list1);
        System.out.println(list);
        //
    }
}
