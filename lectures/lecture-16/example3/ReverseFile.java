import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * Read in the file given as the first command-line arg and print out
 * the lines in the file in reverse order.
 */
class ReverseFile {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(args[0]));

        for (int lineIndex = lines.size() - 1; lineIndex >= 0 ; lineIndex -= 1) {
            System.out.println(lines.get(lineIndex));
        }
    }
}
