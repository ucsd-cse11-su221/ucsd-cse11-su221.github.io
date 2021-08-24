
class Point {
    int x;
    int y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
    double distance(Point other) {
      return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }
  }

class Pair<T1, T2> {
    T1 a;
    T2 b;
    Pair(T1 a, T2 b) {
        this.a = a;
        this.b = b;
    }
}

class SimpleGenerics {

    //Withotu angle brackets causes warnings!
    //Pair<String, String> strs = new Pair("apple", "banana");
    
    Pair<String, String> strs = new Pair<>("apple", "banana");

    Pair<String, Point> labelledPoint = new Pair<>("fruit", new Point(4, 5));

    String strsBField = strs.b;
    Point labelledBField = labelledPoint.b;

}
