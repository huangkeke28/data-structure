package java_03_04.myExtends;

public class Bird extends Animal{


    public Bird(String name) {
        super(name);
    }

    public void fly() {
        System.out.println(this.name + "正在飞");
    }

    public void eat(String food) {
        System.out.println("这是bird.eat");
        System.out.println(name + " 正在吃 " + food);
    }
}
