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

interface Region { // Added an interface declaration with the shared method
  boolean contains(Point p);
  Region add(Region r);
}

class RectRegion implements Region { // Declared "implements Region" (the interface)
  Point lowerLeft;
  Point upperRight;
  RectRegion(Point lowerLeft, Point upperRight) {
    this.lowerLeft = lowerLeft;
    this.upperRight = upperRight;
  }
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
  public boolean contains(Point p) {
    return this.center.distance(p) < this.radius;    
  }
}

class UnionRegion implements Region {
  Region r1;
  Region r2;
  UnionRegion(Region r1, Region r2) {
    this.r1 = r1;
    this.r2 = r2;
  }
  public boolean contains(Point p) {
    return this.r1.contains(p) || this.r2.contains(p);
  }

  public Region add(Region other) {
    return new UnionRegion(this, other);
  }
}

class IntersectRegion implements Region {
  Region r1;
  Region r2;
  IntersectRegion(Region r1, Region r2) {
    this.r1 = r1;
    this.r2 = r2;
  }
  public boolean contains(Point p) {
    return this.r1.contains(p) && this.r2.contains(p);
  }
}

//Represent all points in region1 that aren't in region2
class SubtractRegion implements Region {
  Region r1;
  Region r2;
  SubtractRegion(Region r1, Region r2) {
    this.r1 = r1;
    this.r2 = r2;
  }

  /*
  public boolean contains(Point p) {
    if (this.r1.contains(p) && r2.contains(p)) {
      return false;
    }
    else {
      return this.r1.contains(p);
    }
  }
*/

  public boolean contains(Point p) {
    return this.r1.contains(p) && !this.r2.contains(p);
  }
}


class SquareRegion implements Region {
  Point center;
  double sideLength;
  SquareRegion(Point center, double sideLength) {
    this.center = center;
    this.sideLength = sideLength;
  }
  public boolean contains(Point p) {
    int xDiff = Math.abs(p.x - this.center.x);
    int yDiff = Math.abs(p.y - this.center.y);
    boolean xInside = (xDiff < (this.sideLength / 2));
    boolean yInside = (yDiff < (this.sideLength / 2));
    return xInside && yInside;
  }
}

class CircleRegion implements Region {
  Point center;
  double radius;
  CircleRegion(Point center, double radius) {
    this.center = center;
    this.radius = radius;
  }
  public boolean contains(Point toCheck) {
    return this.center.distance(toCheck) <= this.radius;
  }

  public Region add(Region other) {
    return new UnionRegion(this, other);
  }
}

class ExamplesRegion {
  //Region circ1 = new CircleRegion(new Point(10, 5), 4.0);
  //Region sq = new SquareRegion(new Point(10, 1), 8.);
  //Region ir = new IntersectRegion(this.circ1, this.sq);


  Region circA = new CircleRegion(new Point(6, 5), 3);
  Region circB = new CircleRegion(new Point(12, 5), 3);
  Region circC = new CircleRegion(new Point(18, 5), 3);

  Region all3Circle = 
      new UnionRegion(this.circA, new UnionRegion(this.circB, this.circC));

  // Region all6Circles = 
  //     new UnionRegion(this.circA, 
  //     new UnionRegion(this.circB, 
  //     new UnionRegion(this.circC, 
  //     new UnionRegion(this.circD, 
  //     new UnionRegion(this.circE, this.circF)))));

  Region all3Circles2 = this.circA.add(this.circB).add(this.circC);

  // Add "Region add(Region r)" to the Region interface
  // Put add method in CircleRegion
}
