import java.lang.reflect.Field;

public class StringTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "Hello";
        //filed对应到某个对象中的一个具体的字段
        Field field = String.class.getDeclaredField("value");
                //获取到String这个类对象 类加载过程 把.class文件中的二进制指令加载到内存中，同时生成一个对应的类对象
        //在这个类对象里包含这一些关于这个类的信息
        //类是一张图纸 对象是盖出来的房子 房子消耗空间 图纸本事也对应着一个"类对象"
        //每个类都有一个自己对应的类对象，相互之间是不关联的
        field.setAccessible(true);
        //由于String中的字符是private的 直接不能修改也不能访问 先把这个字段改成可访问的

        //获取str 中 value 数组的具体内容
        char[] value = (char[]) field.get(str);
        value[0] = 'a';
//        for (int i = 0; i < value.length; i++) {
////            System.out.println(value[i]);
////        }
//        System.out.println(str);
        //每次执行 += 都会创造一个新的比较长的字符串，效率低下 应避免使用 +=

    }
}
