import java.util.Scanner;

import wordladder.AStar;
import wordladder.GBFS;
import wordladder.GBFS2;
import wordladder.Process;
import wordladder.UCS;
import wordladder.Result;

public class Main {
    public static void main(String[] args) {
        Scanner userChoice = new Scanner(System.in);

        System.out.println("Choose the algorithm:");
        System.out.println("    1. A* search (optimal and complete)");
        System.out.println("    2. Uniform cost search (optimal and complete)");
        System.out.println("    3. Greedy best-first search first variant (not optimal but complete)");
        System.out.println("    4. Greedy best-first search second vairant (not optimal and not complete)");
        System.out.println("Note:   ");
        System.out.println("Optimal: Always finds the best solution.");
        System.out.println("Complete: Always finds a solution if there are any.\n");


        System.out.print("Algorithm choice: ");
        int algorithmChoice = userChoice.nextInt();
        if (algorithmChoice < 1 || algorithmChoice > 4) {
            System.out.println("Invalid choice.");
            System.exit(0);
        }

        System.out.print("Starting word: ");
        String source = userChoice.next();

        if (!Process.checkLength(source.length())) {
            System.out.println("No word with length " + source.length() + " is in the dictionary.");
            System.exit(0);
        }

        Process.createGraph(source.length());
        if (!Process.checkWord(source)) {
            System.out.println(source + " is not in the dictionary.");
            System.exit(0);
        }

        System.out.print("Ending word: ");
        String destination = userChoice.next();
        userChoice.close();

        if (source.length() != destination.length()) {
            System.out.println("The lengths differ.");
            System.exit(0);
        }
        if (!Process.checkWord(destination)) {
            System.out.println(destination + " is not in the dictionary.");
            System.exit(0);
        }

        Result result = null;

        long startTime = System.nanoTime();
        if (algorithmChoice == 1) {
            result = AStar.solve(source, destination);
        } else if (algorithmChoice == 2) {
            result = UCS.solve(source, destination);
        } else if (algorithmChoice == 3) {
            result = GBFS.solve(source, destination);
        } else if (algorithmChoice == 4) {
            result = GBFS2.solve(source, destination);
        } else {
            System.out.println("Invalid algorithm choice");
            System.exit(0);
        }
        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / 1000000;
        if (result.getPath() != null) {
            System.out.println(result.getPath());
            System.out.println("Number of nodes in the path: " + result.getPath().size());
        } else {
            System.out.println("Path not found");
        }
        System.out.println("Total nodes visited: " + result.getTotalNodesVisited());
        System.out.println("Time taken: " + duration + " ms");
    }
}
