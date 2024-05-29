import java.util.*;

public class problem6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> vertices = new HashSet<>();

        System.out.println("Enter edges as 'u v' (space-separated, directed), or type 'done' to finish:");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                String[] parts = input.split("\\s+");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);

                vertices.add(u);
                vertices.add(v); // Collect unique vertices
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input format. Please use 'u v' with space separation.");
            }
        }

        int n = vertices.size();
        int[][] adjacencyMatrix = new int[n][n];
        Map<Integer, Integer> vertexToIndex = new HashMap<>(); // Mapping vertex to matrix index

        // Assign indices to vertices for matrix representation
        int index = 0;
        for (int vertex : vertices) {
            vertexToIndex.put(vertex, index++);
        }

        // Re-scan input to fill the adjacency matrix
        scanner = new Scanner(System.in); // Reset scanner
        System.out.println("Enter edges again:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                String[] parts = input.split("\\s+");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);

                int uIndex = vertexToIndex.get(u);
                int vIndex = vertexToIndex.get(v);
                adjacencyMatrix[uIndex][vIndex]++; // Increment for multiple edges
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                // (Error handling remains the same)
            }
        }

        // Print the adjacency matrix
        System.out.println("\nAdjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
