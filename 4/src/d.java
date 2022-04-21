import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class d {
    public static void main(String[] args) throws FileNotFoundException {
        part1();
        part2();
    }

    public static void part1() throws FileNotFoundException {
        FileReader input = new FileReader("4/src/input.txt");
        Scanner lines = new Scanner(input);
        int prev = 0;
        int person = 0;
        boolean sleep = false;
        HashMap<Integer, HashMap<Integer, Integer>> ids = new HashMap<Integer, HashMap<Integer, Integer>>();
        ArrayList<String> result = new ArrayList<String>();
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            result.add(line);
        }
        java.util.Collections.sort(result);
        for (String line : result) {
            String[] parts = line.split("] ");
            String[] times = parts[0].split(" ");
            //System.out.println(Arrays.toString(times));
            if (parts[1].startsWith("Guard")) {
                int startIndex = parts[1].indexOf("#");
                int endIndex = parts[1].substring(startIndex).indexOf(" ");
                person = Integer.parseInt(parts[1].substring(startIndex+1, startIndex+endIndex));
            } else {
                if (parts[1].startsWith("falls")) {
                    prev = Integer.parseInt(times[1].split(":")[1]);
                    sleep = true;
                } else if (parts[1].startsWith("wakes")) {
                    if (!sleep) {
                        continue;
                    }
                    String day = times[0].substring(1);
                    int cur = Integer.parseInt(times[1].split(":")[1]);
                    //System.out.println(person+" "+day+" "+prev+ " " + cur);
                    ids.putIfAbsent(person, new HashMap<Integer, Integer>());
                    for (int i = prev; i < cur; i++) {
                        ids.get(person).put(i, ids.get(person).getOrDefault(i, 0) + 1);
                    }
                    sleep = false;
                }
            }
        }
        int id = ids.entrySet().stream().max((e1, e2) -> e1.getValue().values().stream().mapToInt(Integer::intValue).sum() - e2.getValue().values().stream().mapToInt(Integer::intValue).sum()).get().getKey();
        int minute = ids.get(id).entrySet().stream().max((e1, e2) -> e1.getValue() - e2.getValue()).get().getKey();
        System.out.println(id+" "+minute+" = "+id*minute);
        //System.out.println(ids.get(id).values().stream().mapToInt(Integer::intValue).sum());
    }
    public static void part2() throws FileNotFoundException {
        FileReader input = new FileReader("4/src/input.txt");
        Scanner lines = new Scanner(input);
        int prev = 0;
        int person = 0;
        boolean sleep = false;
        HashMap<Integer, HashMap<Integer, Integer>> ids = new HashMap<Integer, HashMap<Integer, Integer>>();
        ArrayList<String> result = new ArrayList<String>();
        while (lines.hasNextLine()) {
            String line = lines.nextLine();
            result.add(line);
        }
        java.util.Collections.sort(result);
        for (String line : result) {
            String[] parts = line.split("] ");
            String[] times = parts[0].split(" ");
            //System.out.println(Arrays.toString(times));
            if (parts[1].startsWith("Guard")) {
                int startIndex = parts[1].indexOf("#");
                int endIndex = parts[1].substring(startIndex).indexOf(" ");
                person = Integer.parseInt(parts[1].substring(startIndex+1, startIndex+endIndex));
            } else {
                if (parts[1].startsWith("falls")) {
                    prev = Integer.parseInt(times[1].split(":")[1]);
                    sleep = true;
                } else if (parts[1].startsWith("wakes")) {
                    if (!sleep) {
                        continue;
                    }
                    String day = times[0].substring(1);
                    int cur = Integer.parseInt(times[1].split(":")[1]);
                    //System.out.println(person+" "+day+" "+prev+ " " + cur);
                    ids.putIfAbsent(person, new HashMap<Integer, Integer>());
                    for (int i = prev; i < cur; i++) {
                        ids.get(person).put(i, ids.get(person).getOrDefault(i, 0) + 1);
                    }
                    sleep = false;
                }
            }
        }
        List<Integer> keys = ids.entrySet().stream().map(e -> e.getValue().entrySet().stream().max((e1, e2) -> e1.getValue() - e2.getValue()).get().getKey()).collect(Collectors.toList());
        List<Integer> values = ids.entrySet().stream().map(e -> e.getValue().entrySet().stream().max((e1, e2) -> e1.getValue() - e2.getValue()).get().getValue()).collect(Collectors.toList());
        int target = values.stream().max(Integer::compareTo).get();
        int index = values.indexOf(target);
        int key = IntStream.range(0, keys.size()).peek(num -> System.out.println(keys.get(num))).filter(num -> values.get(num) == target).findFirst().getAsInt();
        int targetMinute = keys.get(key);
        List<Integer> objectKeys = ids.keySet().stream().toList();
        int targetPerson = objectKeys.get(index);
        System.out.println(targetPerson+" "+targetMinute+" = "+targetPerson*targetMinute);
    }
}