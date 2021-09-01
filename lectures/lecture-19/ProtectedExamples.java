import pairpackage.A;

class B extends A {
    B(int x) {
        this.x = x;
    }
    int getX() {
        return this.x;
    }
}

public class ProtectedExamples {
 
    public static void main(String[] args) {
        B b = new B(10);
        //System.out.println(b.x);  //produces an error! x not visible
        System.out.println(b.getX());
    }
}
