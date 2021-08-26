import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class AverageFile {
    // Read in doubles from the path given as the first argument, and
    // print out the mean of those numbers. Assume the file has one number per
    // line.
  
    // What if the file had the numbers separated by spaces rather than by lines?
    public static void main(String[] args) throws IOException {

      //averagePerLine(args[0]);
      averageOneLine(args[0]);
    }

    static void averagePerLine(String filename) throws IOException {
      List<String> lines = Files.readAllLines(Paths.get(filename));

      //Convert list to array of strings
      String[] numbers = new String[lines.size()];

      for (int i = 0; i < lines.size(); i++) {
        numbers[i] = lines.get(i);
      }

      System.out.println("Average: " + average(numbers));
    }


    static void averageOneLine(String filename) throws IOException {
      List<String> lines = Files.readAllLines(Paths.get(filename));

      //Convert string into an array of strings
      String[] numbers = lines.get(0).split(" ");

      System.out.println("Average: " + average(numbers));
    }


    static double average(String[] numbers) {
      double total = 0;

      for (String s: numbers) {
        total += Double.parseDouble(s);
      }

      if (numbers.length == 0) {
        System.out.println("No numbers in file");
        return 0;
      }

      return total / numbers.length;
    }
    
  }