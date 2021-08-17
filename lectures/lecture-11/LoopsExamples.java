import tester.*;

class LoopsExamples {

    //Returns the sum of the lengths of the strings instrs
    //for ANY length array that is given to us
    int sumOfLengths(String[] strs) {

        //We need a way to do the sum for all the elements, no matter how many there are
        int sum = 0;

        for (String s: strs) {
            sum = sum + s.length();
        }

        return sum;

        // if (strs.length == 3) {
        //     return strs[0].length() + strs[1].length() + strs[2].length();
        // }
        // else {
        //     return strs[0].length() + strs[1].length() + strs[2].length() + strs[3].length();
        // }
    }

    String[] fruit = { "apple", "banana", "cucumber" };     //19
    String[] letters = { "b", "e", "a", "r" };              //4

    boolean testSumOfLengths(Tester t) {
        return t.checkExpect(this.sumOfLengths(fruit), 19) &&
               t.checkExpect(this.sumOfLengths(letters), 4);
    }

    //Write a method that takes an array of int and returns 
    //the product (multiplication) of those numbers
    int product(int[] nums) {
        int total = 1;

        for (int n: nums) {
            total = total * n;
        }

        return total;
    }

    int[] nums1 = { 2, 4, 6 };          //48
    int[] nums2 = { 5, 3, 1, 2, 1 };    //30

    boolean testProduct(Tester t) {
        return t.checkExpect(this.product(nums1), 48) &&
               t.checkExpect(this.product(nums2), 30);
    }

    //average: take an array of double and return a double
    //representing the average (mean)
    double average(double[] doubles) {
        double total = 0.0;
        //int count = 0;

        for (double d: doubles) {
            total = total + d;
            //count = count + 1;
        }

        //return total / count;
        return total / doubles.length;
    }

    double[] ds1 = { 2.0, 4.0, 1.0 };       //  7 / 3
    double[] ds2 = { 5.0, 1.0, 3.0, 6.0 };  // 15 / 4

    boolean testAverage(Tester t) {
        return t.checkExpect(this.average(ds1), 7.0 / 3.0) &&
               t.checkExpect(this.average(ds2), 15.0 / 4.0) &&
               t.checkExpect(this.average(ds3), 0.0);
    }
}
