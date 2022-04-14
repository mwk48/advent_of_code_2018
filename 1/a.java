import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class a {
    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        FileReader input = new FileReader("input.txt");
        Scanner lines = new Scanner(input);
        int total=0;
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            total+=Integer.parseInt(line);
            //System.out.println(line);
        }
        System.out.println(total);
        lines.close();
    }
    public static void part2() throws FileNotFoundException {

    }
}