class Lecture04Ex {

    //Write the method to calculate absolute value that takes a number and 
    //returns the negation if it’s less than 0, or that number otherwise
    int absolute(int number) {
        if (number < 0) {
            return -1 * number;     //then branch
        }
        else {
            return number;          //else branch
        }
    }

    int abs1 = this.absolute(-2);	//should produce 2
    int abs2 = this.absolute(4);	//should produce 4

    //weeklyPay: takes a number of hours worked and an hourly rate, and returns 
    //the pay with overtime (over 40 hours) counting as double the rate
    //ASSUME: hours and rate are both positive
    int weeklyPay(int hoursWorked, int hourlyRate) {
        if (hoursWorked < 0 || hourlyRate < 0) {
            return 0;
        }

        if (hoursWorked > 40) {
            //return (hoursWorked * hourlyRate) + ((hoursWorked - 40) * (hourlyRate * 2));  //logic error - incorrect answer
            //return (40 * hourlyRate) + ((hoursWorked - 40) * (hourlyRate * 2));           //works
            return (hoursWorked * hourlyRate) + ((hoursWorked - 40) * hourlyRate);          //also works
        }
        else {
            return hoursWorked * hourlyRate;
        }
    }

    int wp1 = this.weeklyPay(45, 10);       //500
    int wp2 = this.weeklyPay(35, 10);       //350
    int wp3 = this.weeklyPay(-35, 10);
    int wp4 = this.weeklyPay(35, -10);


    //https://codingbat.com/prob/p183071
    //Given 2 ints, a and b, return their sum. 
    //However, sums in the range 10..19 inclusive, 
    //are forbidden, so in that case just return 20.
    public int sortaSum(int a, int b) {
        if (a + b >= 10 && a + b <= 19) {
            return 20;
        }

        return a + b;
    }

    int ss1 = sortaSum(3, 4);   // → 7
    int ss2 = sortaSum(9, 4);   // → 20
    int ss3 = sortaSum(10, 11); // → 21
    int ss4 = sortaSum(6, 4);   // → 20
    int ss5 = sortaSum(15, 4);  // → 20
}
