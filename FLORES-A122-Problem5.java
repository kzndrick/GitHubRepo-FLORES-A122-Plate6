import java.util.*;

public class problem5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<Integer>> graph = new HashMap<>();

        System.out.println("Enter edges as 'u v' and type 'done' to finish:");

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
                graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input format. Please use 'u v' with space separation.");
            }
        }

        boolean isBipartite = isBipartite(graph);
        if (isBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }

    // Function to check if a graph is bipartite using BFS
    public static boolean isBipartite(Map<Integer, List<Integer>> graph) {
        int[] colors = new int[graph.size()];
        Arrays.fill(colors, -1); // Initialize all vertices as not colored

        for (int startVertex : graph.keySet()) {
            if (colors[startVertex] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(startVertex);
                colors[startVertex] = 0; // Color the starting vertex

                while (!queue.isEmpty()) {
                    int currentVertex = queue.poll();
                    for (int neighbor : graph.get(currentVertex)) {
                        if (colors[neighbor] == -1) {
                            // Color neighbor with the opposite color
                            colors[neighbor] = 1 - colors[currentVertex];
                            queue.offer(neighbor);
                        } else if (colors[neighbor] == colors[currentVertex]) {
                            // If neighbor has the same color, not bipartite
                            return false; 
                        }
                    }
                }
            }
        }

        return true; // All vertices colored without conflicts, so bipartite
    }
}
