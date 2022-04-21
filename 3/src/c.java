import java.util.*;
import java.io.*;

public class c {
    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        FileReader input = new FileReader("3/src/input.txt");
        Scanner lines = new Scanner(input);
        HashMap<String, Integer> items = new HashMap<String, Integer>();
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            String[] parts = line.split(": ");
            String[] anotherParts = parts[0].split(" @ ");
            int[] coordinates = Arrays.stream(anotherParts[1].split(",")).mapToInt(Integer::parseInt).toArray();
            int[] moves = Arrays.stream(parts[1].split("x")).mapToInt(Integer::parseInt).toArray();
            for (int i=coordinates[0];i<coordinates[0]+moves[0];i++) {
                for (int j=coordinates[1];j<coordinates[1]+moves[1];j++) {
                    String key = i + "," + j;
                    items.put(key, items.getOrDefault(key, 0) + 1);
                }
            }
        }
        System.out.println(items.values().stream().filter(x -> x > 1).count());
        lines.close();
    }
    public static void part2() throws FileNotFoundException {
        FileReader input = new FileReader("3/src/input.txt");
        Scanner lines = new Scanner(input);
        HashMap<String, Integer> items = new HashMap<String, Integer>();
        HashMap<String, ArrayList<String>> ids = new HashMap<String, ArrayList<String>>();
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            String[] parts = line.split(": ");
            String[] anotherParts = parts[0].split(" @ ");
            int[] coordinates = Arrays.stream(anotherParts[1].split(",")).mapToInt(Integer::parseInt).toArray();
            int[] moves = Arrays.stream(parts[1].split("x")).mapToInt(Integer::parseInt).toArray();
            ArrayList<String> result = new ArrayList<String>();
            for (int i=coordinates[0];i<coordinates[0]+moves[0];i++) {
                for (int j=coordinates[1];j<coordinates[1]+moves[1];j++) {
                    String key = i + "," + j;
                    items.put(key, items.getOrDefault(key, 0) + 1);
                    result.add(key);
                }
            }
            ids.put(anotherParts[0], result);
        }
        for (var entry : ids.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            long count = value.stream().filter(x -> items.get(x) == 1).count();
            if (count==value.size()) {
                System.out.println(key);
            }
        }
    }
}