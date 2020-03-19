import javax.lang.model.element.NestingKind;

public class StringClass {
    public static void main(String[] args) {
        //1.创建字符串
        //字符串常量池 StringBuffer StringBuilder
//        String str = "Hello World";
//        String str2 = new String("Hello world");
//        String str3 = "Hello World";
//        System.out.println(str == str3);
//        char[] array = {'a', 'b', 'c'};
//        String str4 = new String(array);
//        System.out.println(str4);
//        String string = new String("Hello");
//        String string2 = new String("Hello");
//        System.out.println(string == string2);
        //字符串常量池：如" Hello "这样的字符串字面常量，也是需要一定的内存空间来存储的
        //这样的常量具有一个特点。就是不需要修改，所以如果代码中有许多引用都需要使用"Hello"
        //的话，就直接引用到常量池的这个位置就行了，而没必要把"Hello"在内存中存储两次

        //面向对象编程语言中 涉及到对象的比较 有三种不同的方式 比较身份 比较值 比较类型
//        String string4 = new String("Hello");
//        String string5 = new String("Hello");
//        System.out.println(string4.equals(string5));
        //String类的设计使用了共享设计模式
        //在JVM底层实际上会自动维护一个对象池（字符串常量池）
        //如果使用String构造方法就会开辟两块堆内存空间 并且其中一块内存空间将称为垃圾空间
        //可以使用String的intern方法来手动把String对象加入到字符串常量池中
//        String str11 = new String("Hello").intern();
//        String str22 = "Hello";
//        System.out.println(str11 == str22);
        //请解释String类中两种对象实例化的区别
        //1.直接赋值：会开辟一块堆内存空间 并且该字符串对象可de以自动保存在对象池中以供下次使用
        //2.构造方法：会开辟两块堆内存空间，不会保存在对象池中，但可以使用inter()方法手工入池
        //一般采取直接赋值的方法创建String对象


        //理解字符串不可改变
        //字符串是一种不可改变的对象 它的内容不可改变
        //String类的内部实现也是基于char[]来实现的，但是String类中并没有提供set之类的方法来修改内部的字符数组
//
//        String str2222 = "hello";
//        str2222 = str2222 + "world";
//        str2222 += "!!!!";
//        System.out.println(str2222);
        //表面上好像是修改了字符串 其实不然 不是String对象的本事发生改变 而是str引用到了其他的对象
        //如何修改字符串
        //a)常见办法 借助原字符串 创建新的字符串
//        String string = "Hello";
//        string = "h" + string.substring(1);
//        System.out.println(string);
        //b)使用"反射"这样的操作可以破坏封装，访问一个内部类的private成员
//        String string = "helloworld";
//        System.out.println(string.charAt(4));
        //将字符串变为字符数组
//        char[] data = string.toCharArray();
//        System.out.println(Arrays.toString(data));
//        for (int i = 0; i < data.length; i++) {
//            System.out.print(data[i] + " ");
//        }
        //字符数组转为字符串
//        System.out.println(new String(data));
//        System.out.println(new String(data,1,2));

        //给定一个字符串 判断是否全部由数字组成
//        String string = "3545";
//        System.out.println(isNumber2(string));

        //字节常用于数据传输以及编码转换处理之中 String也能方便和byte[]相互转换
        //实现字符串与字节数组的转换处理
//        String string = "helloworld";
//        byte[] data = string.getBytes();
//        for (int i = 0; i < data.length; i++) {
//            System.out.print(data[i] + " ");
//        }
//        System.out.println(new String(data));
//        System.out.println("A".compareTo("a"));
//        System.out.println("a".compareTo("A"));
//        System.out.println("AB".compareTo("AC"));
//        System.out.println("刘".compareTo("杨"));

//        String string = "hello world";
//        System.out.println(string.contains(" "));
//        System.out.println(string.indexOf("bit"));

        //实现字符串的拆分处理
//        String string  = "hello world hello bit";
//        String[] result = string.split(" ",8);
//        for (String s: result) {
//            System.out.println(s);
//        }
        //拆分ip地址
//        String string = "192.168.1.1";
//        String[] result = string.split("\\.");
//        for (String s: result) {
//            System.out.println(s);
//        }
//        String string = "name=zhangsan&age=18";
//        String[] result = string.split("&");
//        for (int i = 0; i < result.length; i++) {
//            String[] temp = result[i].split("=");
//            System.out.println(temp[0] + " = " + temp[1]);
//        }
//        String string = "   hello world  ";
//        System.out.println("[" + string + "]");
//        System.out.println("[" + string.trim() + "]");
//        System.out.println("hello".isEmpty());
//        System.out.println("".isEmpty());
//        System.out.println(new String().isEmpty());
//
        //首字母大写
//        String name = "huangke";
//        System.out.println(fistUpper(name));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("hello").append("world");
//        fun(stringBuffer);
//        System.out.println(stringBuffer);
//        System.out.println(stringBuffer.reverse());
//        System.out.println(stringBuffer.delete(5, 10));
        System.out.println(stringBuffer.delete(5, 10).insert(0, "你好"));
    }

    public static void fun(StringBuffer temp) {
        temp.append(" ").append("www.bit.con.cn");
    }
    public static String fistUpper(String name) {
        String tmp = name.substring(0, 1);
        String x = tmp.toUpperCase();
        return new String(x + name.substring(1));
    }

    public static String main(String str) {
        if ("".equals(str) || str == null) {
            return str;
        }
        if (str.length() > 1) {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
        return str.toUpperCase();
    }
//    public static boolean isNumber(String string) {
//        for (int i = 0; i < string.length(); i++) {
//            char a = string.charAt(i);
//            if (a < '0' || a > '9') {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean isNumber2(String string) {
//        char[] data = string.toCharArray();
//        for (int i = 0; i < data.length; i++) {
//            if (data[i] < '0' || data[i] > '9') {
//                return false;
//            }
//        }
//        return true;
//    }
}
