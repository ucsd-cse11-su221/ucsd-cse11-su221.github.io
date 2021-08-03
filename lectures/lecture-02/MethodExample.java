class MethodExample {
    int sos1 = 3 * 3 + 5 * 5;       //9 + 25 -> 34
    int sos2 = 4 * 4 + 7 * 7;       //16 + 49 -> 65

    int sumSquares(int n, int m) { 
        return (n * n) + (m * m);
    }

    int ans1 = this.sumSquares(3, 5);
    int ans2 = this.sumSquares(4, 7);

    String someMethod(String s1, int i1) {
        return s1 + i1;
    }

    String str1 = this.someMethod("a", 5);
    //String str2 = this.someMethod(5, "a");    //compiler error, arguments types do not match parameters types
    //String str2 = this.someMethod(i2=5, s1="a");  //java does not support named parameters
}
