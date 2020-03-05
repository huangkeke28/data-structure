package java_03_04.myExtends;

public class Cat extends Animal {
    public Cat(String name) {
        //在子类的构造方法中，调用父类的构造方法
        super(name);
    }
}
