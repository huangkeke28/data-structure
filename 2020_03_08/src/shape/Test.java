package shape;

public class Test {
    public static void main(String[] args) {
        //接口使用过程中同样也是依赖多态这样的语法
        Ishape shape = new Circle();
        shape.draw();
    }
}
