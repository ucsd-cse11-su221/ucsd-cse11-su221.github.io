import tester.*;

class ArrayExamples {
    //int[] nums = { 4, 2, 7 };

    //int firstNumber = this.nums[0];
    //int secondNumber = this.nums[1];
    //int thirdNumnber = this.nums[2];
    //int fourthNumber = this.nums[3];  //out of bounds

    String[] strs = { "a", "b", "c", "y" };
    //String[] nAndS = { 2, "b", "z" };     //int cannot be converted to a string

    int countStrs = strs.length;


    int[] nums = { 4, 2, 7 };
    int[] nums2 = nums;
    int[] emptyNums = { };
    
    //Return true if the array has no elements, false otherwise
    boolean isEmpty(int[] array) {
        // if (array.length > 0) {
        //     return false;
        // }
        // else {
        //     return true;
        // }

        return array.length == 0;
    }

    boolean testEmpty(Tester t) {
        return t.checkExpect(this.isEmpty(nums), false) &&
               t.checkExpect(this.isEmpty(emptyNums), true);
    }
}
