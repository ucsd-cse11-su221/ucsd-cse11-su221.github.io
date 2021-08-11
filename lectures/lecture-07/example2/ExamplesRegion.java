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
}

interface Region {
  boolean contains(Point p);
}

class RectRegion implements Region {
  Point lowerLeft;
  Point upperRight;
  RectRegion(Point lowerLeft, Point upperRight) {
    this.lowerLeft = lowerLeft;
    this.upperRight = upperRight;
  }

  /*
    @param p The coordinates of a point to check for containment within this region
    @return true if the coordinate is contained in the region, false otherwise
  */
  public boolean contains(Point p) {
    return this.lowerLeft.belowLeftOf(p) && this.upperRight.aboveRightOf(p);
  }
}

class CircRegion implements Region {
  Point center;
  int radius;
  CircRegion(Point center, int radius) {
    this.center = center;
    this.radius = radius;
  }
  /*
    @param p the point to check for containment within the circle
    @return true if the point is within radius units of the center of the circle
  */
  public boolean contains(Point p) {
    return this.center.distance(p) < this.radius;    
  }
}

class UnionRegion implements Region {
  Region r1, r2;
  UnionRegion(Region r1, Region r2) {
    this.r1 = r1;
    this.r2 = r2;
  }
  public boolean contains(Point toCheck) {
    return this.r1.contains(toCheck) || this.r2.contains(toCheck);
  }
}

class IntersectRegion implements Region {
  Region r1, r2;
  IntersectRegion(Region r1, Region r2) {
    this.r1 = r1;
    this.r2 = r2;
  }
  public boolean contains(Point toCheck) {
    return this.r1.contains(toCheck) && this.r2.contains(toCheck);
  }
}


class ExamplesRegion {
  Region r1 = new RectRegion(new Point(30, 40), new Point(100, 200));
  Region r2 = new RectRegion(new Point(10, 10), new Point(50, 50));
  Point p1 = new Point(10, 10);
  Point p2 = new Point(50, 50);
  Region r3 = new RectRegion(p1, p2);

  Point toTest1 = new Point(60, 60);
  Point toTest2 = new Point(20, 20);

  boolean testContains(Tester t) {
    return t.checkExpect(this.r1.contains(this.toTest1), true) &&
           t.checkExpect(this.r2.contains(this.toTest1), false) &&
           t.checkExpect(this.r3.contains(this.toTest1), false) &&
           t.checkExpect(this.r1.contains(this.toTest2), false) &&
           t.checkExpect(this.r2.contains(this.toTest2), true) &&
           t.checkExpect(this.r3.contains(this.toTest2), true);
  }

  Region c1 = new CircRegion(new Point(200, 50), 10);
  Region c2 = new CircRegion(new Point(20, 300), 25);

  Point circleTest1 = new Point(209, 50);
  Point circleTest2 = new Point(20, 315);

  boolean testContainsCirc(Tester t) {
    return t.checkExpect(this.c1.contains(this.circleTest1), true) &&
           t.checkExpect(this.c1.contains(this.circleTest2), false) &&
           t.checkExpect(this.c2.contains(this.circleTest1), false) &&
           t.checkExpect(this.c2.contains(this.circleTest2), true);
  }

  Region u1 = new UnionRegion(this.c1, this.r1);

  boolean testContainsRegion(Tester t) {
    //These first two we know should work because they were in the original
    //tests for the shapes composed into Region u1
    t.checkExpect(this.u1.contains(this.circleTest1), true);
    t.checkExpect(this.u1.contains(this.toTest1), true);

    //to the left of the rectangle and the circle
    t.checkExpect(this.u1.contains(circleTest2), false);

    //to the right and above
    t.checkExpect(this.u1.contains(new Point(1000, 1000)), false);

    return true;
  }

}
