class MainExample {

    int x = 5;

    static int sum(int n, int m) {
        //int y = this.x;   //no this - static method
        return n + m;
    }

    public static void main(String[] args) {
        //System.out.println("Hello");
        //System.out.println("CSE 11!");

        //System.out.println(MainExample.sum(6, 7));

        String s1 = args[0];
        System.out.println(s1);

    }

}
