import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.IntStream;

public class f {
    public static void main(String[] args) throws FileNotFoundException {
        //part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        FileReader input = new FileReader("6/src/input.txt");
        Scanner lines = new Scanner(input);
        ArrayList<String> coordinates = new ArrayList<>();
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            coordinates.add(line);
        }
        String[][] grid = new String[500][500];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                final int y=i, x=j;
                int[] target = coordinates.stream().mapToInt(s -> Math.abs(y-Integer.parseInt(s.split(", ")[1]))+Math.abs(x-Integer.parseInt(s.split(", ")[0]))).toArray();
                int min = Arrays.stream(target).min().getAsInt();
                long count = Arrays.stream(target).filter(num -> num == min).count();
                int index = IntStream.range(0, coordinates.size()).filter(i2 -> target[i2] == min).findFirst().getAsInt();
                if (count > 1) {
                    grid[i][j] = ".";
                    continue;
                }
                grid[i][j] = coordinates.get(index);
            }
        }
        Set<String> exclude = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            exclude.add(grid[i][0]);
            exclude.add(grid[i][grid[i].length-1]);
            exclude.add(grid[0][i]);
            exclude.add(grid[grid.length-1][i]);
        }
        HashMap<String, Integer> table = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (exclude.contains(grid[i][j])) {
                    continue;
                }
                table.put(grid[i][j], table.getOrDefault(grid[i][j], 0)+1);
            }
        }
        System.out.println(table.values().stream().max(Integer::compareTo).get());
    }
    public static void part2() throws FileNotFoundException {
        FileReader input = new FileReader("6/src/input.txt");
        Scanner lines = new Scanner(input);
        ArrayList<String> coordinates = new ArrayList<>();
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            String newLine = Integer.parseInt(line.split(", ")[0])+", "+Integer.parseInt(line.split(", ")[1]);
            coordinates.add(newLine);
        }
        String[][] grid = new String[500][500];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                final int y=i, x=j;
                int[] target = coordinates.stream().mapToInt(s -> Math.abs(y-Integer.parseInt(s.split(", ")[1]))+Math.abs(x-Integer.parseInt(s.split(", ")[0]))).toArray();
                int min = Arrays.stream(target).min().getAsInt();
                long count = Arrays.stream(target).filter(num -> num == min).count();
                int index = IntStream.range(0, coordinates.size()).filter(i2 -> target[i2] == min).findFirst().getAsInt();
                if (count > 1) {
                    grid[i][j] = ".";
                    continue;
                }
                grid[i][j] = coordinates.get(index);
            }
        }
        int total=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                final int y=i, x=j;
                int distance = coordinates.stream().mapToInt(s -> Math.abs(y-Integer.parseInt(s.split(", ")[1]))+Math.abs(x-Integer.parseInt(s.split(", ")[0]))).sum();
                if (distance < 10000) {
                    //System.out.println(i+","+j+" "+distance);
                    total++;
                }
            }
        }
        System.out.println(total);
    }
}
