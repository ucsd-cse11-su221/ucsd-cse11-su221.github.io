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
  Region add(Region other);
  Region overlap(Region other);
}

abstract class ARegion implements Region {
  public Region add(Region other) {
    return new UnionRegion(this, other);
  }

  public Region overlap(Region other) {
    return new IntersectRegion(this, other);
  }
}

class RectRegion extends ARegion { // Declared "implements Region" (the interface)
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

class CircRegion extends ARegion {
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

class UnionRegion extends ARegion {
  Region r1;
  Region r2;
  UnionRegion(Region r1, Region r2) {
    this.r1 = r1;
    this.r2 = r2;
  }
  public boolean contains(Point p) {
    return this.r1.contains(p) || this.r2.contains(p);
  }
}

class IntersectRegion extends ARegion {
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

class SquareRegion extends ARegion {
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

class CircleRegion extends ARegion {
  Point center;
  double radius;
  CircleRegion(Point center, double radius) {
    this.center = center;
    this.radius = radius;
  }
  public boolean contains(Point toCheck) {
    return this.center.distance(toCheck) <= this.radius;
  }
}

class ExamplesRegion {
  Region circ1 = new CircleRegion(new Point(10, 5), 4.0);
  Region sq = new SquareRegion(new Point(10, 1), 8.);
  Region ur = this.circ1.add(this.sq);

  //Region ir = new IntersectRegion(this.circ1, this.sq);
  Region ir = this.circ1.overlap(this.sq);
}
