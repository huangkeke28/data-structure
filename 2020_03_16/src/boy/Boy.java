package boy;

public class Boy implements Comparable<Boy>{
    private String name;
    private int money;
    private int faceValue;

    public Boy(String name, int money, int faceValue) {
        this.name = name;
        this.money = money;
        this.faceValue = faceValue;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", faceValue=" + faceValue +
                '}';
    }

    @Override
    public int compareTo(Boy o) {
        if (this.money > o.money) {
            return -1;
        }
        if (this.money < o.money) {
            return 1;
        }
        if (this.faceValue > o.faceValue) {
            return -1;
        }
        if (this.faceValue < o.faceValue) {
            return 1;
        }
        return 0;
    }
}
