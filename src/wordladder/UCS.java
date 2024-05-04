package wordladder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class UCS {
    public static List<String> solve(String source, String destination) {
        Queue<String> queue = new ArrayDeque<String>();
        Set<String> visited = new TreeSet<>();
        Map<String, String> cameFrom = new HashMap<>();

        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (String neighbour : Process.adjacency.get(current)) {
                if (visited.contains(neighbour)) {
                    continue;
                }

                visited.add(neighbour);
                cameFrom.put(neighbour, current);
                queue.offer(neighbour);

                if (neighbour.equals(destination)) {
                    List<String> path = new ArrayList<>();
                    while (neighbour != source) {
                        path.add(neighbour);
                        neighbour = cameFrom.get(neighbour);
                    }
                    path.add(source);
                    path = path.reversed();
                    return path;
                }
            }
        }
        return null;
    }
}
