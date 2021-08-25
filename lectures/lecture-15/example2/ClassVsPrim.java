class Pair<TypeOfA, TypeOfB> {
    TypeOfA a;
    TypeOfB b;
    Pair(TypeOfA a, TypeOfB b) {
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

public class ClassVsPrim {

  //Pair<int, int> p = new Pair<>(56, 50);

  // Intger i = new Integer(45);
  // this means the same thing as above
  Integer i = 45;
  Integer i2 = i + 3;

  Pair<Integer, Boolean> p = new Pair<>(45, true);

  int n = i2;
  int n2 = i2.intValue();

  int v = Integer.parseInt("50");
}
