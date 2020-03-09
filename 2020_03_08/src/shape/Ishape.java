package shape;
//接口 interface
//接口比抽象类更近一步，接口是一个特殊的抽象类
//抽象类里面可以包含非抽象的方法和属性
//接口里面只能包含抽象的方法，包含的属性只能是静态常量
//接口不能被实例化，而是通过继承的方式，在子类中重写抽象方法
public interface Ishape {
    void draw();

}
