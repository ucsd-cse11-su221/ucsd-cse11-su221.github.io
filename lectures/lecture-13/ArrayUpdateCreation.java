import jdk.javadoc.internal.tool.Start;
import tester.*;

class ArrayUpdateCreation {
    int[] a = new int[7];
    boolean[] b = new boolean[3];
    double[] d = new double[2];
    String[] strs = new String[3];

    String s0 = strs[0];
    String s1 = strs[1];
    //int lengthofS = s.length();

    {
        this.strs[1] = "abc";
    }

    String s1Again = strs[1];

    // Returns a new array of numbers
    // from start (inclusive) to stop (exclusive)
    int[] range(int start, int stop) {
        int size = stop - start;
        int[] nums = new int[size];
        for (int index = 0; index < size; index += 1) {
            nums[index] = index + start;
        }
        return nums;
    }

    int[] range1 = range(20, 30);
    //              0   1   2   3   4   5   6   7   8   9
    // look like { 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 }
    int[] range2 = range(0, 5);
    // look like { 0, 1, 2, 3, 4 }
}
