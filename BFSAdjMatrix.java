import java.util.*;

public class BFSAdjMatrix {
    private int v;  // Number of vertices
    private int[][] adj;  // Adjacency matrix

    // Constructor to initialize the graph with a given number of vertices
    public BFSAdjMatrix(int v) {
        this.v = v;
        adj = new int[v][v];  // Initialize the adjacency matrix
    }

    // Method to perform BFS starting from a given vertex
    public void BFS(int start) {
        boolean[] visited = new boolean[v];  // Array to track visited vertices
        Arrays.fill(visited, false);  // Initially, no vertices are visited

        Queue<Integer> queue = new LinkedList<>();  // Queue for BFS
        queue.add(start);  // Enqueue the start vertex
        visited[start] = true;  // Mark the start vertex as visited

        System.out.println("BFS traversal starting from vertex " + start + ":");

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            int vertex = queue.poll();  // Dequeue a vertex
            System.out.print(vertex + " ");  // Print the current vertex

            // Explore all adjacent vertices
            for (int i = 0; i < v; i++) {
                // If there is an edge and the vertex has not been visited
                if (adj[vertex][i] == 1 && !visited[i]) {
                    queue.add(i);  // Enqueue the adjacent vertex
                    visited[i] = true;  // Mark it as visited
                }
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of vertices
        System.out.print("Enter the number of vertices: ");
        int v = scanner.nextInt();

        BFSAdjMatrix graph = new BFSAdjMatrix(v);

        // Read the adjacency matrix
        System.out.println("Enter the adjacency matrix (" + v + "x" + v + "): ");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                graph.adj[i][j] = scanner.nextInt();
            }
        }

        // Read the starting vertex for BFS
        System.out.print("Enter the starting vertex for BFS: ");
        int start = scanner.nextInt();

        // Perform BFS traversal
        graph.BFS(start);

        scanner.close();  // Close the scanner to free resources
    }
}
