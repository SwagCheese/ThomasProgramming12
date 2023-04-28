import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class HappyOrSad {
    public static void main(String[] args) {
        try {
            File file = new File(Objects.requireNonNull(HappyOrSad.class.getResource("happyorsad.txt")).toURI());
            Scanner scanner = new Scanner(file);

            String line = scanner.nextLine();

            int happy = 0, sad = 0;

            Matcher happyMatcher = Pattern.compile(":-\\)").matcher(line);
            Matcher sadMatcher = Pattern.compile(":-\\(").matcher(line);

            while (happyMatcher.find()) ++happy;
            while (sadMatcher.find()) ++sad;

            if (happy == 0 && sad == 0) {
                System.out.println("none");
            } else if (happy == sad) {
                System.out.println("unsure");
            } else if (happy > sad) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        } catch (FileNotFoundException | URISyntaxException e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}