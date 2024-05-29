import java.util.*;

public class FLORES-A122-Problem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<Integer>> graph = new HashMap<>();

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();
        scanner.nextLine(); // Consume newline after reading the integer

        for (int i = 0; i < numVertices; i++) {
            graph.put(i, new ArrayList<>()); // Initialize empty adjacency lists
        }

        System.out.println("Enter edges as 'u v' (space-separated), or type 'done' to finish:");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                String[] parts = input.split("\\s+");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);

                // Validate vertex indices
                if (u < 0 || u >= numVertices || v < 0 || v >= numVertices) {
                    System.out.println("Invalid vertex index. Please enter valid indices within 0 to " + (numVertices - 1));
                    continue;
                }

                // Add undirected edges
                graph.get(u).add(v);
                graph.get(v).add(u);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input format. Please use 'u v' with space separation.");
            }
        }

        boolean isConnected = isConnected(graph);

        if (isConnected) {
            System.out.println("The graph is connected.");
        } else {
            int numComponents = countConnectedComponents(graph);
            System.out.println("The graph is not connected.");
            System.out.println("Number of connected components: " + numComponents);
        }
    }

    // Check if the graph is connected using DFS
    public static boolean isConnected(Map<Integer, List<Integer>> graph) {
        if (graph.isEmpty()) return true; // Empty graph is connected
        
        boolean[] visited = new boolean[graph.size()];
        dfs(graph, 0, visited); // Start DFS from vertex 0 (or any other)

        // Check if all vertices have been visited
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
    
    public static void dfs(Map<Integer, List<Integer>> graph, int currentVertex, boolean[] visited){
        visited[currentVertex] = true;
        for (int neighbor : graph.get(currentVertex)) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
    
 // Count the number of connected components using DFS
    public static int countConnectedComponents(Map<Integer, List<Integer>> graph) {
        int count = 0;
        boolean[] visited = new boolean[graph.size()];

        for (int vertex : graph.keySet()) {
            if (!visited[vertex]) {
                dfs(graph, vertex, visited);
                count++;
            }
        }

        return count;
    }
}
