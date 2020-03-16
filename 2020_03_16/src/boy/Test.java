package boy;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Boy[] boys = {
                new Boy("吴彦祖", 120, 130),
                new Boy("蔡徐坤", 80, 90),
                new Boy("胡歌", 120, 150),
                new Boy("巨魔战将", 20, 20)
        };
        sort(boys);
        System.out.println(Arrays.toString(boys));
    }

    //Comparable本来带一个泛型参数 这个参数也可以没有 没有就表示Object
    public static void sort(Comparable[] array){
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1].compareTo(array[cur]) > 0) {
                    Comparable tmp = array[cur - 1];
                    array[cur - 1] = array[cur];
                    array[cur] = tmp;
                }
            }
        }
    }

}
