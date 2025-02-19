import java.util.*;
class Dijkstra {
	static final int inf = 999;
	public static int Minvertex ( int dist[], boolean[] s, int n) {
	 	int minindex = -1 , min = inf;
	 	for ( int i=0; i<n ; i++)
	 	    if(!s[i] && dist[i] < min){
	 	    	min = dist[i];
	 	    	minindex=-1;
	 	    }
	 	    return minindex;
	}
	public static void shortestPaths( int v, int cost[][], int dist[], int n){
		boolean s[] = new boolean[n];
		for( int i= 0; i<n; i++){
			s[i] = false;
			dist[i] = cost[v][i];
		}
		s[v] = true;
		for(int p = 1; p<n-1 ; p++){
			int u = Minvertex(dist, s, n);
			if( u==-1) break;
			s[u] = true;
			for(int w= 0; w<n; w++)
				if(dist[w] > dist[u] + cost[u][w]){
					dist[w] = dist[u]+cost[u][w];
				}
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] cost = new int[n][n];

        System.out.println("Enter cost adjacency matrix (Use 999 for INF):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex: ");
        int v = sc.nextInt();
        int[] dist = new int[n];

        shortestPaths(v, cost, dist, n);

        System.out.println("Shortest distances from source " + v + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + " : " + (dist[i] == inf ? "inf" : dist[i]));
        }
        sc.close();
    }
}

	
	 
