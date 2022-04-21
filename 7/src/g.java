import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.IntStream;

public class g {
    public static void main(String[] args) throws FileNotFoundException {
        //part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        FileReader input = new FileReader("7/src/input.txt");
        Scanner lines = new Scanner(input);
        HashMap<String, Integer> indegree = new HashMap<>();
        HashMap<String, ArrayList<String>> edges = new HashMap<>();
        Set<String> keys = new HashSet<>();
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            String[] caps = line.chars().mapToObj(c -> (char) c).filter(c -> Character.isUpperCase(c)).map(String::valueOf).toArray(String[]::new);
            indegree.put(caps[2], indegree.getOrDefault(caps[2], 0)+1);
            edges.putIfAbsent(caps[1], new ArrayList<>());
            edges.get(caps[1]).add(caps[2]);
            keys.add(caps[1]);
            keys.add(caps[2]);
        }
        String[] first = keys.stream().filter(key -> !indegree.containsKey(key)).toArray(String[]::new);
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (String node : first) {
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.print(node);
            for (String child : edges.getOrDefault(node, new ArrayList<>())) {
                indegree.put(child, indegree.get(child)-1);
                if (indegree.get(child) == 0) {
                    queue.add(child);
                }
            }
        }
        lines.close();
    }
    public static void part2() throws FileNotFoundException {
        FileReader input = new FileReader("7/src/input.txt");
        Scanner lines = new Scanner(input);
        HashMap<String, Integer> indegree = new HashMap<>();
        HashMap<String, ArrayList<String>> edges = new HashMap<>();
        Set<String> keys = new HashSet<>();
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            String[] caps = line.chars().mapToObj(c -> (char) c).filter(c -> Character.isUpperCase(c)).map(String::valueOf).toArray(String[]::new);
            indegree.put(caps[2], indegree.getOrDefault(caps[2], 0)+1);
            edges.putIfAbsent(caps[1], new ArrayList<>());
            edges.get(caps[1]).add(caps[2]);
            keys.add(caps[1]);
            keys.add(caps[2]);
        }
        String[] first = keys.stream().filter(key -> !indegree.containsKey(key)).toArray(String[]::new);
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (String node : first) {
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            String node = queue.poll();
            System.out.print(node);
            for (String child : edges.getOrDefault(node, new ArrayList<>())) {
                indegree.put(child, indegree.get(child)-1);
                if (indegree.get(child) == 0) {
                    queue.add(child);
                }
            }
        }
        lines.close();
    }
}
