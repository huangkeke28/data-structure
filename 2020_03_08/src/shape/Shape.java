package shape;
//加上abstract这个关键字之后 Shape这个类就变成了抽象类
//抽象类和普通类相比，大部分都是一样的(可以有属性，可以有方法，可以使用静态成员，可以被继承，也可以被别的类继承)
//最主要的区别在抽象类无法实例化
//抽象类中可以包含抽象方法 普通类中无法包含抽象方法
abstract public class Shape {
    //抽象方法使用abstract关键字，没有方法体
    abstract public void draw();
    //抽象类和抽象方法存在意义，就是为了被继承，然后重写
}
