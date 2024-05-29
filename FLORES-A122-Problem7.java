import java.util.*;

public class problem7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> vertices = new HashSet<>();
        List<int[]> edges = new ArrayList<>();
        int edgeCount = 0;

        System.out.println("Enter edges and weights as 'u v weight' (space-separated), or type 'done' to finish:");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                String[] parts = input.split("\\s+");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int weight = Integer.parseInt(parts[2]);

                vertices.add(u);
                vertices.add(v);
                edges.add(new int[] {u, v, weight});
                edgeCount += weight; // Total number of edges including duplicates
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid input format. Please use 'u v weight' with space separation.");
            }
        }

        int numVertices = vertices.size();
        int[][] incidenceMatrix = new int[numVertices][edgeCount];

        int edgeIndex = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            for (int i = 0; i < weight; i++) { // Repeat for each occurrence
                // In incidence matrix, set 1 for both vertices connected to the edge
                incidenceMatrix[u][edgeIndex] = 1;
                incidenceMatrix[v][edgeIndex] = 1;
                edgeIndex++;
            }
        }

        // Print incidence matrix
        System.out.println("\nIncidence Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < edgeCount; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
