import java.util.Arrays;
import java.util.Scanner;

public class SumOfSubsets {
    private int n, m;
    private int[] w, x;

    public SumOfSubsets(int n, int m, int[] weights) {
        this.n = n;
        this.m = m;
        this.w = weights;
        this.x = new int[n];
    }

    public void sumOfSub(int s, int k, int r) {
        if (s == m) {
            printSolution();
            return;
        }

        if (k >= n || s > m || s + r < m)
            return;

        x[k] = 1;
        sumOfSub(s + w[k], k + 1, r - w[k]);

        x[k] = 0;
        sumOfSub(s, k + 1, r - w[k]);
    }

    private void printSolution() {
        System.out.print("Solution: ");
        for (int i = 0; i < n; i++)
            System.out.print(x[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] weights = new int[n];
        int sum = 0;

        System.out.println("Enter the weights:");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            sum += weights[i];
        }

        System.out.print("Enter required sum (m): ");
        int m = scanner.nextInt();

        Arrays.sort(weights); 

        System.out.println("Sorted Weights: " + Arrays.toString(weights));

        SumOfSubsets solver = new SumOfSubsets(n, m, weights);
        System.out.println("Possible solutions:");
        solver.sumOfSub(0, 0, sum);

    }
}
