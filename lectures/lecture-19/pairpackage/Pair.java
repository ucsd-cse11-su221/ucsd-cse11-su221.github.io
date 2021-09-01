package pairpackage;

public class Pair {
    int a, b;
    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int addComponents() {
        return this.a + this.b;
    }

    public String toString() {
        return "(" + this.a + ", " + this.b + ")";
    }
}
