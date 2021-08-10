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
  double xDistance(Point other) {
    return Math.abs(this.x = other.x);
  }
  double yDistance(Point other) {
    return Math.abs(this.y = other.y);
  }
}

interface Region {
  boolean contains(Point p);
}

class UnionRegion {
  Region r1, r2;
  UnionRegion(Region r1, Region r2) {
    this.r1 = r1;
    this.r2 = r2;
  }
  public boolean contains(Point p) {
    return this.r1.contains(p) || this.r2.contains(p);
  }
}

class SquareRegion implements Region {
  Point center;
  double sideLength;
  SquareRegion(Point center, double sideLength) {
    this.center = center;
    this.sideLength = sideLength;
  }
  public boolean contains(Point toCheck) {
    return this.center.xDistance(toCheck) <= (this.sideLength/ 2) &&
           this.center.yDistance(toCheck) <= (this.sideLength / 2);
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
}

class ExamplesRegion {
  Region circ = new CircleRegion(new Point(10, 5), 4);
  Region square = new SquareRegion(new Point(5, 6), 8);
  UnionRegion ur = new UnionRegion(this.square, this.circ);
  boolean b1 = this.ur.contains(new Point(13, 5));
}
