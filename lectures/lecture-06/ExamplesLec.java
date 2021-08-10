import tester.*;

class ExamplesLec {

    double average(double n1, double n2) {

        double sum = n1 + n2;   //sum is a local variable
        return sum / 2.0;

        //return (n1 + n2) / 2.0;
    }

    boolean testAverage(Tester t) {
        ExamplesLec ex = new ExamplesLec(); //ex is a local variable
            //(a reference to a new ExamplesLec object)

        return t.checkExpect(ex.average(1, 2), 3.0 / 2.0);
        //return t.checkExpect(this.average(1, 2), 3.0 / 2.0);
    }

    int weeklyPay(int hours, int rate) {
        int pay = hours * rate;

        if (hours > 40) {
            pay += (hours - 40) * rate;
        }

        return pay;
    }

    int wp1 = this.weeklyPay(45, 10);   //500
    int wp2 = this.weeklyPay(35, 10);   //350
    int wp3 = this.weeklyPay(55, 10);   //700

    boolean testWeeklyPay(Tester t) {
        return t.checkExpect(this.weeklyPay(45, 10), 500) && 
               t.checkExpect(this.weeklyPay(35, 10), 350) &&
               t.checkExpect(this.weeklyPay(55, 10), 700);
    }
}
