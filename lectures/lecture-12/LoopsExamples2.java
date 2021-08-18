import tester.*;

class LoopsExamples2 {


    public static void main(String[] args) {

        for (int num = 0; num < 7; num = num + 1) {
            System.out.println("num is: " + num);
        }

        System.out.println("outside of loop");
    }

    // write sumEvens- takes an array of ints and 
    // returns the sum of just the even ones
    // { 1, 2, 7, 4 } --> 6
    // { 4, 2, 4, 5 } --> 10
    // { 0, -2, 7, 4, 8 } --> 10
    int sumEvens(int[] array) {
        int sum = 0;

        for (int num: array) {
            if (num % 2 == 0) {
                sum += num;
            }
        }

        return sum;
    }

    int[] sum1 = { 1, 2, 7, 4 };
    int[] sum2 = { 4, 2, 4, 5 };
    int[] sum3 = { 0, -2, 7, 4, 8 };

    boolean testSumEvens(Tester t) {
        t.checkExpect(this.sumEvens(sum1), 6);
        t.checkExpect(this.sumEvens(sum2), 10);
        t.checkExpect(this.sumEvens(sum3), 10);

        return true;
    }


    // sumEveryOther: which adds up the elements at the even indices
    // in an array of int and returns the result
    int sumEveryOther(int[] nums) {
        int total = 0;

        for (int index = 0; index < nums.length; index += 2) {
            total += nums[index];
        }
        
        return total;
    }

    int[] array1 = { 1, 2, 4, 5 };
    int[] array2 = { 1, 2, 4, 5, 100 };

    boolean testSumEveryOther(Tester t) {
        t.checkExpect(this.sumEveryOther(array1), 5);
        t.checkExpect(this.sumEveryOther(array2), 105);

        return true;
    }


    //factorial: takes a number n and return n!
    int factorial(int n) {
        int result = 1;
        
        for (int current = 1; current <= n; current += 1) {
            result = result * current;
        }

        return result;
    }

    int result1 = factorial(4);     //should be 24
    int result2 = factorial(5);     //should be 120
    int result3 = factorial(6);     //should be 720


    //factorial2: takes a number n and return n!
    int factorial2(int n) {
        int result = 1;
        
        for (int current = n; current > 0; current -= 1) {
            result = result * current;
        }

        return result;
    }

    int result1fact2 = factorial2(4);     //should be 24
    int result2fact2 = factorial2(5);     //should be 120
    int result3fact2 = factorial2(6);     //should be 720



    //factorial2: takes a number n and return n!
    //recursion - a method that calls itself - creates a loop
    int factorial3(int n) {
        //base case - teminates the "loop"
        if (n <= 1) {
            return 1;
        }

        //recursive case - call to to the same method
        //to solve the same problem, just smaller version of it
        return n * factorial3(n - 1);
    }

    int result1fact3 = factorial3(4);     //should be 24
    int result2fact3 = factorial3(5);     //should be 120
    int result3fact3 = factorial3(6);     //should be 720
}
