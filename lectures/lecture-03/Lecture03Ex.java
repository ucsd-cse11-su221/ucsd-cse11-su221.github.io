class Lecture03Ex {
    boolean b1 = 4 < 5;
    boolean b2 = 5 < 4;
    
    boolean b3 = 4 == 4;	//checks for equality
    boolean b4 = 4 == 5;

    boolean b5 = 5 > 4;
    boolean b6 = 5 >= 4;

    boolean b7 = 4 != 5;
    boolean b8 = 5 != 5;

    // >, <, <=, == are comparison operators returning booleans

    //boolean stringComp = "a" < "b";
    boolean stringComp1 = "a" == "a";
    boolean stringComp2 = "a" == "b";


    boolean and1 = true && true;
    boolean and2 = true && false;
    boolean and3 = false && true;
    boolean and4 = false && false;
    
    boolean or1 = true || true;
    boolean or2 = true || false;
    boolean or3 = false || true;
    boolean or4 = false || false;


    //Write a method that takes a number and returns 
    //true if it’s in the region in our number line example
    boolean numberLine1(int number) {
        return number >= 2;
    }

    boolean example1 = this.numberLine1(2);     //true
    boolean example2 = this.numberLine1(5);     //true
    boolean example3 = this.numberLine1(-1);    //false

    boolean numberLine2(int number) {
        return ((number >= 5) && (number <= 7)) || (number < 2);
    }

    boolean example1b = this.numberLine2(2);     //false
    boolean example2b = this.numberLine2(5);     //true
    boolean example3b = this.numberLine2(-1);    //true
    boolean example4b = this.numberLine2(6);     //true
}
