package wordladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GBFS2 {
    public static boolean dfs(String node, String destination, Set<String> visited, Map<String, String> cameFrom) {
        if (node.equals(destination)) {
            return true;
        }
        String smallestNeighbour = null;
        int smallestH = 99999999;

        for (String neighbour : Process.adjacency.get(node)) {
            if (smallestNeighbour == null || h(neighbour, destination) < smallestH) {
                smallestH = h(neighbour, destination);
                smallestNeighbour = neighbour;
            }
        }

        if (smallestNeighbour == null || visited.contains(smallestNeighbour)) {
            return false;
        }

        visited.add(smallestNeighbour);
        cameFrom.put(smallestNeighbour, node);
        return dfs(smallestNeighbour, destination, visited, cameFrom);
    }

    public static Result solve(String source, String destination) {
        Set<String> visited = new TreeSet<>();
        Map<String, String> cameFrom = new HashMap<>();

        visited.add(source);
        boolean found = dfs(source, destination, visited, cameFrom);
        
        if (!found) {
            return new Result(null, visited.size());
        }

        List<String> path = new ArrayList<>();
        String current = destination;
        while (!current.equals(source)) {
            path.add(current);
            current = cameFrom.get(current);
        }
        path.add(source);
        path = path.reversed();
        return new Result(path, visited.size());
    }

    private static int h(String current, String destination) {
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) != destination.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
