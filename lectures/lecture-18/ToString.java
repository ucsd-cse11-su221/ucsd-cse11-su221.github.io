import java.util.Arrays;
import java.util.List;

// class Pair {
//     int a, b;
//     Pair(int a, int b) {
//         this.a = a;
//         this.b = b;
//     }

//     public String toString() {
//         return "(" + this.a + ", " + this.b + ")";
//     }
// }

class ToString {
    public static void main(String[] args) {
        Integer i = 40;
        Integer[] nums = { 4, 5, 6 };
        Pair p1 = new Pair(4, 5);
        Pair p2 = new Pair(10, 15);
        Pair p3 = new Pair(20, 22);
        List<Integer> ints = Arrays.asList(1, 2, 3);
        List<Pair> pairs = Arrays.asList(p1, p2, p3, p1);

        System.out.println(i.toString());
        System.out.println(nums.toString());
        System.out.println(p1.toString());
        System.out.println(ints.toString());
        System.out.println(pairs.toString());

        System.out.println(Arrays.toString(nums));
    }
}
