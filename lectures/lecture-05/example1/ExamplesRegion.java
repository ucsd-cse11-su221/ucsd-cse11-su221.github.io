class Point {
    int x;
    int y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    double distance(Point other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) 
            + Math.pow(this.y - other.y, 2));
      }
  }

  class CircRegion {
    Point center;
    int radius;
    CircRegion(Point center, int radius) {
      this.center = center;
      this.radius = radius;
    }

    boolean contains(Point p) {
        return this.center.distance(p) < this.radius;
      }
  }

class ExamplesRegion {
    CircRegion c1 = new CircRegion(new Point(200, 50), 10);
    Point circleTest1 = new Point(209, 50);
    boolean contains1 = this.c1.contains(this.circleTest1);
}
