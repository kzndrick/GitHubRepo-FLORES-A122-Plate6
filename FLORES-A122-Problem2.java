import java.util.*;

public class problem2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get matrix dimensions
        System.out.print("Enter the number of vertices in the graph: ");
        int n = scanner.nextInt();

        // Create and populate the adjacency matrix
        int[][] adjMatrix = new int[n][n];
        System.out.println("Enter the adjacency matrix (" + n + " x " + n + "):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = scanner.nextInt();
            }
        }

        // Find and count edges
        Map<String, Integer> edgeCounts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // Only consider upper triangle
                if (adjMatrix[i][j] > 0) {
                    String edge = i + " " + j; // Create an edge identifier
                    edgeCounts.put(edge, adjMatrix[i][j]); // Store the count
                }
            }
        }

        // Output the results
        System.out.println("\nEdges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
