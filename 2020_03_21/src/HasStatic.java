public class HasStatic {
    private static int x = 100;

    public static void main(String[] args) {
        HasStatic hasStatic1 = new HasStatic();
        hasStatic1.x++;
        HasStatic hasStatic2 = new HasStatic();
        hasStatic2.x++;
        hasStatic1 = new HasStatic();
        hasStatic1.x++;
        HasStatic.x--;
        System.out.println("x=" + x);

    }
}
