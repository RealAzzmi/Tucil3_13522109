package wordladder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GBFS {
    public static List<String> solve(String source, String destination) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getF)); // f(n) = h(n) di
                                                                                                      // greedy best
                                                                                                      // first search
        Map<String, String> cameFrom = new HashMap<>();
        Map<String, Integer> hScore = new HashMap<>();

        hScore.put(source, h(source, destination));
        priorityQueue.add(new Node(source, h(source, destination)));

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            String currentWord = current.getWord();

            // Biar ga visit ulang sehingga dijamin tidak kuadratik.
            if (hScore.get(currentWord) != current.getF()) {
                continue;
            }

            for (String neighbour : Process.adjacency.get(currentWord)) {
                if (neighbour.equals(destination)) {
                    cameFrom.put(neighbour, currentWord);
                    List<String> path = new ArrayList<>();
                    while (neighbour != source) {
                        path.add(neighbour);
                        neighbour = cameFrom.get(neighbour);
                    }
                    path.add(source);
                    path = path.reversed();
                    return path;
                }

                if (!hScore.containsKey(neighbour)) {
                    cameFrom.put(neighbour, currentWord);
                    hScore.put(neighbour, h(neighbour, destination));
                    priorityQueue.add(new Node(neighbour, h(neighbour, destination)));
                }
            }
        }
        return null;
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
