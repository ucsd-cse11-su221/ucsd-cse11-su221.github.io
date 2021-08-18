import tester.*;

class LoopsExamples {

    //Returns the sum of the lengths of the strings in strs
    //for ANY length array that is given to us
    int sumOfLengths(String[] strs) {
        int sum = 0;

        for (String s: strs) {
            sum = sum + s.length();
        }

        return sum;
    }

    String[] fruit = { "apple", "banana", "cucumber" };
    String[] letters = { "b", "e", "a", "r" };

    boolean testSumOfLengths(Tester t) {
        return t.checkExpect(this.sumOfLengths(fruit), 19) &&
               t.checkExpect(this.sumOfLengths(letters), 4);
    }


    //Write a method product that takes an array of int and returns
    //the product (multiplication) of those numbers
    int product(int[] nums) {
        int total = 1;

        for (int n: nums) {
            total = total * n;
        }

        return total;
    }

    int[] nums1 = { 2, 4, 6 };          // 48
    int[] nums2 = { 5, 3, 1, 2, 1 };    // 30

    boolean testProduct(Tester t) {
        return t.checkExpect(this.product(nums1), 48) &&
               t.checkExpect(this.product(nums2), 30);
    }


    //average: take an array of doubles and return a double representing 
    //the average (mean)
    double average(double[] doubles) {
        double total = 0.0;
        //int count = 0;

        for (double d: doubles) {
            total = total + d;
            //count = count + 1;
        }

        if (doubles.length == 0) {
            return 0.0;
        }

        //return total / count;
        return total / doubles.length;
    }

    double[] ds1 = { 2.0, 4.0, 1.0 };           //  7/3
    double[] ds2 = { 5.0, 1.0, 3.0, 6.0 };      // 15/4
    double[] ds3 = { };

    boolean testAverage(Tester t) {
        return t.checkExpect(this.average(ds1), 7.0 / 3.0) &&
               t.checkExpect(this.average(ds2), 15.0 / 4.0) &&
               t.checkExpect(this.average(ds3), 0.0);
    }

    //average: take an array of doubles and return a double representing 
    //the average (mean)
    double averageNonNegatives(double[] doubles) {
        double total = 0.0;
        int count = 0;

        for (double d: doubles) {
            if (d >= 0) {
                total = total + d;
                count = count + 1;
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return total / count;
    }

    double[] ds4 = { 5, 6, -5, -6 };        //11 / 2
    double[] ds5 = { -5, -6, -7, -8 };      //0

    boolean testAverageNonNegative(Tester t) {
        return t.checkExpect(this.averageNonNegatives(ds4), 11.0 / 2.0) && 
               t.checkExpect(this.averageNonNegatives(ds3), 0.0) &&
               t.checkExpect(this.averageNonNegatives(ds5), 0.0);
    }



}
