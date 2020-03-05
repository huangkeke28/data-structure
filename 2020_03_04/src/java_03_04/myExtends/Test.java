package java_03_04.myExtends;

public class Test {
    public static void main(String[] args) {
//        Animal animal = new Animal("小动物");
//            animal.eat("爆米花");
//            //Animal是cat的父类
//        //就可以理解成Cat 也是一种Animal
//        //这样的代码就叫"向上转型"
//        Cat cat = new Cat("小猫");
//        feed(cat);
//        cat.eat("老鼠");
//        Bird bird = new Bird("小鸟");
//        bird.eat("谷子");
//        bird.fly();
//        bird.name = "中国人";
//        bird.eat("中国菜");
//        Animal animal2 = findMyAnimal();
        Animal animal = new BlueCat("小动物");
        animal.eat("冰淇淋");
        Bird bird = new Bird("xxxx");
        bird.eat("谷子");
    }
//向上转型：父类引用指向子类对象 mua~
    public static void feed(Animal animal) {
        animal.eat("冰淇淋");
    }

    public static Animal findMyAnimal() {
        Bird bird = new Bird("圆圆");
        return bird;
    }
}
