import java.util.*;
import java.io.*;
public class a {
    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        FileReader input = new FileReader("1/input.txt");
        Scanner lines = new Scanner(input);
        int total=0;
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            total+=Integer.parseInt(line);
        }
        System.out.println(total);
        lines.close();
    }
    public static void part2() throws FileNotFoundException {
        FileReader input = new FileReader("1/input.txt");
        HashMap<Integer,Integer> table = new HashMap<Integer,Integer>();
        table.put(0,1);
        ArrayList<Integer> items = new ArrayList<Integer>();
        Scanner lines = new Scanner(input);
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            int num = Integer.parseInt(line);
            items.add(num);
        }
        int index=0;
        int total=0;
        while (true) {
            total+=items.get((index++)%items.size());
            table.put(total,table.getOrDefault(total,0)+1);
            if (table.get(total)==2) {
                System.out.println(total);
                break;
            }
        }
        //System.out.println(items.size());
    }
}