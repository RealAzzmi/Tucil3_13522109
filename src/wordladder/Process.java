package wordladder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Process {
    public static Map<String, List<String>> adjacency = new HashMap<>();

    public static void createGraph(int length) {
        String pathLocation = String.format("%s%d%s", "src/wordladder/dictionary/word_size_", length, ".txt");
        Path path = Paths.get(pathLocation);
        try {
            List<String> lines = Files.readAllLines(path);
            Set<String> treeSet = new TreeSet<>();
            treeSet.addAll(lines);
            for (String line : lines) {
                adjacency.put(line, new ArrayList<>());
            }

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                StringBuilder sb = new StringBuilder(line);
                for (int j = 0; j < length; j++) {
                    char original = sb.charAt(j);
                    for (char k = 'a'; k <= 'z'; k++) {
                        sb.setCharAt(j, k);
                        String to = sb.toString();
                        if (treeSet.contains(to)) {
                            adjacency.get(line).add(to);
                        }
                    }
                    sb.setCharAt(j, original);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
