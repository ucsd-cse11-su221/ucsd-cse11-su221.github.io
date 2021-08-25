//https://docs.oracle.com/en/java/javase/13/docs/api/java.base/java/util/ArrayList.html
import java.util.ArrayList;

class ArrayListExamples {

    //Return a NEW arraylist of just the strings longer than the given length
    static ArrayList<String> longStrings(ArrayList<String> strs, int length) {
        ArrayList<String> toReturn = new ArrayList<>();

        for (String s: strs) {
            if (s.length() > length) {
                toReturn.add(s);
            }
        }

        return toReturn;
    }

    static ArrayList<String> longStrings(ArrayList<String> strs) {
        return longStrings(strs, 5);
    }

    public static void main(String[] args) {
        ArrayList<String> alist = new ArrayList<>();
        ArrayList<String> alist2 = alist;

        alist.add("banana");
        alist.add("apple");
        alist.add("cucumber");

        System.out.println(alist.get(2));
        alist.add(1, "blueberry");

        System.out.println(alist);
        System.out.println(alist.get(2));
        System.out.println(alist2.get(2));

        ArrayList<String> longerThan6 = longStrings(alist, 6);
        System.out.println("Should not contain apple, banana: " + longerThan6);

        ArrayList<String> longerThan5 = longStrings(alist);
        System.out.println("Should not contain apple: " + longerThan5);
    }
}
