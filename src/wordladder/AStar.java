package wordladder;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class AStar {
    public static Result solve(String source, String destination) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Node::getF));
        Map<String, String> cameFrom = new HashMap<>();
        Map<String, Integer> gScore = new HashMap<>();
        Map<String, Integer> fScore = new HashMap<>();

        gScore.put(source, 0);
        fScore.put(source, h(source, destination));
        priorityQueue.add(new Node(source, 0 + h(source, destination)));
        
        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            String currentWord = current.getWord();

            if (currentWord.equals(destination)) {
                List<String> path = new ArrayList<>();
                while (!currentWord.equals(source)) {
                    path.add(currentWord);
                    currentWord = cameFrom.get(currentWord);
                }
                path.add(source);
                path = path.reversed();
                return new Result(path, fScore.size());
            }

            // Biar ga visit ulang sehingga dijamin tidak kuadratik.
            if (fScore.get(currentWord) != current.getF()) {
                continue;
            }

            int currentGscore = gScore.get(currentWord);
            for (String neighbour : Process.adjacency.get(currentWord)) {
                int neighbourGscore = currentGscore + 1;

                if (!gScore.containsKey(neighbour) || neighbourGscore < gScore.get(neighbour)) {
                    cameFrom.put(neighbour, currentWord);
                    gScore.put(neighbour, neighbourGscore);
                    fScore.put(neighbour, neighbourGscore + h(neighbour, destination));
                    priorityQueue.add(new Node(neighbour, neighbourGscore + h(neighbour, destination)));
                }
            }
        }
        return new Result(null, fScore.size());
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
