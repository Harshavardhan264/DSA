import java.util.*;

public class BFSAdjList {
    private int vertices;  
    private LinkedList<Integer>[] adjList;  
    public BFSAdjList(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); 
    }
    public void BFS(int start) {
        boolean[] visited = new boolean[vertices];  
        Queue<Integer> queue = new LinkedList<>();  

        visited[start] = true;
        queue.add(start);

        System.out.println("BFS traversal starting from vertex " + start + ":");

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int neighbor : adjList[vertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = scanner.nextInt();

        BFSAdjList graph = new BFSAdjList(v);

        System.out.print("Enter the number of edges: ");
        int e = scanner.nextInt();

        System.out.println("Enter the edges (format: src dest): ");
        for (int i = 0; i < e; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            graph.addEdge(src, dest);
        }

        System.out.print("Enter the starting vertex for BFS: ");
        int start = scanner.nextInt();

        graph.BFS(start);

        scanner.close();
    }
}
