import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class b {
    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        FileReader input = new FileReader("2/src/input.txt");
        Scanner lines = new Scanner(input);
        int two=0;
        int three=0;
        while (lines.hasNextLine()) {
            HashMap<Character,Integer> table = new HashMap<Character, Integer>();
            String line = lines.nextLine();
            for (int i=0;i<line.length();i++) {
                char c = line.charAt(i);
                table.put(c,table.getOrDefault(c,0)+1);
            }
            two += table.containsValue(2) ? 1 : 0;
            three += table.containsValue(3) ? 1 : 0;
        }
        System.out.println(two*three);
        lines.close();
    }
    public static void part2() throws FileNotFoundException {
        FileReader input = new FileReader("2/src/input.txt");
        ArrayList<String> compare = new ArrayList<String>();
        Scanner lines = new Scanner(input);
        while (lines.hasNextLine()) {
            compare.add(lines.nextLine());
        }
        int length = compare.get(0).length();
        for (int i=0;i<compare.size()-1;i++) {
            for (int j=i+1;j<compare.size();j++) {
                String first = compare.get(i);
                String second = compare.get(j);
                long diff = IntStream.range(0, length).filter(k -> first.charAt(k) != second.charAt(k)).count();
                //System.out.println(diff);
                if (diff == 1) {
                    System.out.println(first);
                    System.out.println(second);
                }
            }
        }
        lines.close();
        //System.out.println(items.size());
    }
}