class Pair<T1, T2> {
    T1 a;
    T2 b;
    Pair(T1 a, T2 b) {
        this.a = a;
        this.b = b;
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
}

class SimpleGenerics {

    //Without angle brackets causes warnings!
    //Pair<String, String> strs = new Pair("apple", "banana");

    //Pair<String, String> strs = new Pair<String, String>("apple", "banana");
    Pair<String, String> strs = new Pair<>("apple", "banana");

    Pair<String, Point> labelledPoint = new Pair<>("fruit", new Point(4, 5));

    String strsBField = strs.b;
    Point labelledBField = labelledPoint.b;

}
