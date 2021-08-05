class Point {
    int x;      //uninitialized field definitions, or field defs. without values
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //quadrant takes no parameters, and returns a string
    //of which quadrant the point is in
    String quadrant() {
        if (this.x > 0 && this.y > 0) { 
            return "1";
        }
        else if (this.x < 0 && this.y > 0) { 
            return "2";
        }
        else if (this.x < 0 && this.y < 0) { 
            return "3";
        }
        else if (this.x > 0 && this.y < 0) { 
            return "4";
        }
        else {
            return "On axis";
        }
    }
}

class ExamplesLec {
    //int weeklyPay(...) { ... }
    //int examplesOfNum = 4 + 5;

    Point fourFivePoint = new Point(4, 5);
    Point negOneThreePoint = new Point(-1, -3);
    Point fourFivePointAgain = this.fourFivePoint;
    Point zeroFivePoint = new Point(0, 5);

    String quadA = this.fourFivePoint.quadrant();       //"1" or "Quadrant 1"
    String quadB = this.negOneThreePoint.quadrant();    //"3"
    String quadC = this.zeroFivePoint.quadrant();       //"On axis"

}
