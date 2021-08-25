import java.util.ArrayList;

public class ExceptionsExamples {

    /**
     * ASSUME that elements is nonempty
     * throws IllegalArgumentException if elements is empty.
     * @param elements
     * @return
     */
    static Integer max(ArrayList<Integer> elements) {
        if (elements.size() == 0) {
            throw new IllegalArgumentException("max got an empty list");
        }

        Integer maxValue = elements.get(0);

        for (Integer i: elements) {
            if (maxValue < i) {
                maxValue = i;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();

        al.add(-5);
        al.add(-10);
        al.add(-7);
        //al.add(0);

        System.out.println(max(al));

        ArrayList<Integer> al2 = new ArrayList<>();
        System.out.println(max(al2));
    }
}
