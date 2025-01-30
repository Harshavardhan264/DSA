import java.util.Arrays;
import java.util.Scanner;

public class DFTWithAdjacencyMatrix {

    public static void DFS(int[][] adjacencyMatrix, int startVertex, boolean[] visited) {
        visited[startVertex] = true;
        System.out.print(startVertex + " ");

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[startVertex][i] == 1 && !visited[i]) {
                DFS(adjacencyMatrix, i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices in the graph: ");
        int vertices = scanner.nextInt();
        
        int[][] graph = new int[vertices][vertices];
        
        System.out.println("Enter the adjacency matrix (0 for no edge, 1 for edge): ");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        boolean[] visited = new boolean[graph.length]; 
        Arrays.fill(visited, false);

        System.out.println("DFS Traversal:");
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                DFS(graph, i, visited);
            }
        }

        scanner.close();
    }
}


//output
Enter the number of vertices in the graph: 5
Enter the adjacency matrix (0 for no edge, 1 for edge): 
0 1 1 0 0
1 0 0 1 0
1 0 0 0 1
0 1 0 0 1
0 0 1 1 0

DFS Traversal:
0 1 3 4 2

