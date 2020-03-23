package collection;

public class A<T> {
    T val;
    A(T val) {
        this.val = val;
    }
    T getVal() {
        return val;
    }

    public static void main(String[] args) {
        A<String> a = new A<>("dfdf");
    }
}
