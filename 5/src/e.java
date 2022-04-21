import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class e {
    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        FileReader input = new FileReader("5/src/input.txt");
        Scanner lines = new Scanner(input);
        String res = lines.nextLine();
        ArrayList<Character> stack = new ArrayList<>();
        for (Character c : res.toCharArray()) {
            stack.add(c);
            while (stack.size()>=2 && (stack.get(stack.size()-2) != stack.get(stack.size()-1)) && Character.toLowerCase(stack.get(stack.size()-2)) == Character.toLowerCase(stack.get(stack.size()-1))) {
                stack.remove(stack.size()-1);
                stack.remove(stack.size()-1);
            }
        }
        System.out.println(stack.size());
        lines.close();
    }
    public static void part2() throws FileNotFoundException {
        FileReader input = new FileReader("5/src/input.txt");
        Scanner lines = new Scanner(input);
        String res = lines.nextLine();
        ArrayList<Character> stack = new ArrayList<>();
        String replaceChars = "abcd";
        Long min = Long.MAX_VALUE;
        for (Character c : replaceChars.toCharArray()) {
            char lower = Character.toLowerCase(c);
            char upper = Character.toUpperCase(c);
            String replaceRes = res.replaceAll(Character.toString(lower), "").replaceAll(Character.toString(upper), "");
            for (Character c2 : replaceRes.toCharArray()) {
                stack.add(c2);
                while (stack.size()>=2 && (stack.get(stack.size()-2) != stack.get(stack.size()-1)) && Character.toLowerCase(stack.get(stack.size()-2)) == Character.toLowerCase(stack.get(stack.size()-1))) {
                    stack.remove(stack.size()-1);
                    stack.remove(stack.size()-1);
                }
            }
            min = Math.min(min, stack.size());
            stack.clear();
        }
        System.out.println(min);
        lines.close();
    }
}
