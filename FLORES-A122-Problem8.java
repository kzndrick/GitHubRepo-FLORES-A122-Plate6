import java.util.*;

public class problem8 {
    public static boolean areIsomorphic(Map<Integer, List<Integer>> graph1, Map<Integer, List<Integer>> graph2) {
		return false;
        // ... (rest of the logic for `areIsomorphic`, `generatePermutations`, and `isIsomorphicMapping` remains unchanged)
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for Graph 1
        Map<Integer, List<Integer>> graph1 = inputGraph(scanner, "Graph 1");

        // Input for Graph 2
        Map<Integer, List<Integer>> graph2 = inputGraph(scanner, "Graph 2");

        System.out.println("Graphs are isomorphic: " + areIsomorphic(graph1, graph2));
    }

    // Function to input graph data from the user
    private static Map<Integer, List<Integer>> inputGraph(Scanner scanner, String graphName) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        System.out.println("Enter edges for " + graphName + " as 'u v' (space-separated), or type 'done' to finish:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                String[] parts = input.split("\\s+");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);

                graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
                graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u); // For undirected graphs
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input format. Please use 'u v' with space separation.");
            }
        }

        return graph;
    }
}
