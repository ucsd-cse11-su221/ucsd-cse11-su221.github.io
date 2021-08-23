import tester.*;

class Point {
  int x;
  int y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  boolean belowLeftOf(Point other) {
    return this.x <= other.x && this.y <= other.y;
  }
  boolean aboveRightOf(Point other) {
    return this.x >= other.x && this.y >= other.y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }

  // Write a method findClosest that takes an array of Points pts and returns
  // the point in the array pts that is the *closest* (according to distance) to
  // this Point

  // Write a method that takes an array of Points pts and an integer dist
  // and returns a new array of all points within dist of this point
  // from that array
  Point[] allWithin(Point[] pts, int dist) {
    int numberWithin = 0;
    for (Point p: pts) {
      if (this.distance(p) < dist) {
        numberWithin += 1;
      }
    }

    Point[] toReturn = new Point[numberWithin];
    int index = 0;

    for (Point p: pts) {
      if (this.distance(p) < dist) {
          toReturn[index] = p;     //array update expression
          index += 1;
      }
    }

    return toReturn;
  }
}

class PointExamples {

  Point p1 = new Point(4, 5);
  Point p2 = new Point(10, 10);
  Point p3 = new Point(100, 100);
  Point p4 = new Point(0, 0);

  Point[] allButP1 = { p2, p3, p4 };
  Point[] allButP1P3 = { p2, p4 };
  Point[] empty = { };

  Point[] result1 = p1.allWithin(allButP1, 20);

  void testAllWithin(Tester t) {
    t.checkExpect(p1.allWithin(allButP1, 20), allButP1P3);
    t.checkExpect(p1.allWithin(allButP1, 3), empty);
  }
}
