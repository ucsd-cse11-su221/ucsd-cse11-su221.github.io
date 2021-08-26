import java.util.ArrayList;

class TextTweet {
    String username;
    String contents;
    int likes;
    TextTweet(String username, String contents, int likes) {
        // likes should not be negative
        // contents should be fewer than 280 characters and at least 1
        // username shouldn't be empty
        if (likes < 0) {
            throw new IllegalArgumentException("likes must be non-negative");
        }
        if (username.length() == 0) {
            throw new IllegalArgumentException("username must contains characters");
        }
        if (contents.length() <= 0 || contents.length() > 280) {
            throw new IllegalArgumentException("contents must be 1 - 280 characters");
        }

        this.username = username;
        this.contents = contents;
        this.likes = likes;
    }
}


public class ExceptionsExamples {

    Exception e = new IllegalArgumentException("this exception isn't being thrown");

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
        //System.out.println(max(al2));


        Exception e1 = new IllegalArgumentException("this is not being thrown from main");
        System.out.println(e1);

        TextTweet t = new TextTweet("joe", "hello!", -1);

    }
}
