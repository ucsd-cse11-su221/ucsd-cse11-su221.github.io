import tester.*;

class LoopsExamples3 {

    String timesTable(int width, int height) {
        String table = "\n";

        for (int row = 1; row <= height; row += 1) {         //outer loop
            for (int col = 1; col <= width; col += 1) {      //inner loop
                table = table + "\t" + (col * row);         // \t -> tab character
            }

            table += "\n";  // \n -> new line character
        }


        return table;
    }

    String tt1 = this.timesTable(5, 5);
    String tt2 = this.timesTable(3, 7);


    //find the max int in an array of ints
    int max(int[] nums) {
        int largest = nums[0];

        for (int n: nums) {
            if (n > largest) {
                largest = n;
            }
        }
        
        return largest;
    }

    int[] max1 = { 1, -1, 5, 6 };       //6
    int[] max2 = { 1, 3, 55, 6, 50 };   //55
    
    int max1Actual = this.max(max1);
    int max2Actual = this.max(max2);

    void testMax(Tester t) {
        int[] max1 = { 1, -1, 5, 6 };       //6
        int[] max2 = { 1, 3, 55, 6, 50 };   //55

        t.checkExpect(this.max(max1), 6);
        t.checkExpect(this.max(max2), 55);
    }

    //sum all int of an array of int but first one
    int sumAllButFirst(int[] arr) {
        boolean pastFirst = false;
        int total = 0;        

        for (int n: arr) {
            if (pastFirst) {
                total += n;
            }
            else {
                pastFirst = true;
            }
        }

        return total;
    }

    int sumAllButFirst2(int[] arr) {
        int total = 0;

        for (int i = 1; i < arr.length; i++) {
            total += arr[i];
        }

        return total;
    }

    void testAllButFirst(Tester t) {
        int[] abf1 = { 1, 9, 100 };         //109
        int[] abf2 = { 1 };                 //0
        int[] abf3 = { 1, 2, 3, 4, 5, 6 };  //20

        t.checkExpect(this.sumAllButFirst(abf1), 109);
        t.checkExpect(this.sumAllButFirst(abf2), 0);
        t.checkExpect(this.sumAllButFirst(abf3), 20);

        t.checkExpect(this.sumAllButFirst2(abf1), 109);
        t.checkExpect(this.sumAllButFirst2(abf2), 0);
        t.checkExpect(this.sumAllButFirst2(abf3), 20);

        t.checkExpect(this.sumAllButFirst3(abf1), 109);
        t.checkExpect(this.sumAllButFirst3(abf2), 0);
        t.checkExpect(this.sumAllButFirst3(abf3), 20);

        t.checkExpect(this.sumAllButFirst4(abf1), 109);
        t.checkExpect(this.sumAllButFirst4(abf2), 0);
        t.checkExpect(this.sumAllButFirst4(abf3), 20);

        // t.checkExpect(this.sumAllButFirst5(abf1), 109);
        // t.checkExpect(this.sumAllButFirst5(abf2), 0);
        // t.checkExpect(this.sumAllButFirst5(abf3), 20);
    }

    int sumAllButFirst3(int[] arr) {
        int total = 0;
        int i = 1;

        while (i < arr.length) {
            total += arr[i];
            i++;                        //i = i + 1
        }

        return total;
    }

    int sumAllButFirst4(int[] arr) {
        int total = 0;
        int i = 0;

        while (i < arr.length - 1) {
            i++;                        //i = i + 1
            total += arr[i];
        }

        return total;
    }

    //fails for empty arrays and arrays of size 1
    // int sumAllButFirst5(int[] arr) {
    //     int total = 0;
    //     int i = 0;

    //     do {
    //         i++;                        //i = i + 1
    //         total += arr[i];
    //     } while (i < arr.length - 1);

    //     return total;
    // }


    int multiplyNums(int start, int end) {
        int total = 1;

        for (int num = start; num <= end; num += 1) {
            //works
            // if (num != 0) {
            //     total *= num;
            // }

            if (num == 0) {
                continue;
            }

            total *= num;
        }

        return total;
    }

    int mult1 = this.multiplyNums(1, 5);        //120
    int mult2 = this.multiplyNums(-5, 5);       //??

    //sum all numbers, but stop at first negative number
    int sumBeforeNegative(int[] arr) {
        int sum = 0;

        for (int n: arr) {
            if (n < 0) {
                break;
            }

            sum += n;
        }

        return sum;
    }

    int[] test1 = { 1, 2, 3, -1, 4, 5, 6 }; //6
    int[] test2 = { 1, 2, 3, 4, 5, 6 };     //21

    int sum1 = this.sumBeforeNegative(test1);
    int sum2 = this.sumBeforeNegative(test2);

    int infiniteLoop() {
        int count = 0;

        while (true) {
            System.out.println(count);
            count += 1;

            if (count == 10) {
                break;
            }
        }

        return count;
    }

    int dummy = this.infiniteLoop();
}
