import java.util.Scanner;

public class GraphColoring {
    private int n, m;
    private int[][] G;
    private int[] x;

    public GraphColoring(int n, int m) {
        this.n = n;
        this.m = m;
        this.G = new int[n][n];
        this.x = new int[n];
    }

    public void mColoring(int k) {
        while (true) {
            nextValue(k);
            if (x[k] == 0) return;
            if (k == n - 1)
                printSolution();
            else
                mColoring(k + 1);
        }
    }

    private void nextValue(int k) {
        while (true) {
            x[k] = (x[k] + 1) % (m + 1);
            if (x[k] == 0) return;

            boolean valid = true;
            for (int j = 0; j < n; j++) {
                if (G[k][j] != 0 && x[k] == x[j]) {
                    valid = false;
                    break;
                }
            }

            if (valid) return;
        }
    }

    private void printSolution() {
        for (int i = 0; i < n; i++)
            System.out.print(x[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = scanner.nextInt();

        System.out.print("Enter number of colors: ");
        int m = scanner.nextInt();

        GraphColoring graphColoring = new GraphColoring(n, m);

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graphColoring.G[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Possible Colorings:");
        graphColoring.mColoring(0);

        scanner.close();
    }
}
