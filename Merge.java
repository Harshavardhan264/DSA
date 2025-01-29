import java.util.Scanner;

class Merge {
    void mergesort(int A[], int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(A, low, mid);         
            mergesort(A, mid + 1, high);    
            merge(A, low, mid, high);    
        }
    }
    void merge(int A[], int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        int[] B = new int[high - low + 1]; 

        // Merge the two sorted subarrays
        while (i <= mid && j <= high) {
            if (A[i] <= A[j]) {
                B[k - low] = A[i];   
                i++;
            } else {
                B[k - low] = A[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            B[k - low] = A[i];
            i++;
            k++;
        }

        while (j <= high) {
            B[k - low] = A[j];
            j++;
            k++;
        }
        for (int h = low; h <= high; h++) {
            A[h] = B[h - low];
        }
    }

    void printArray(int A[]) {
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the No. of elements:");
        int n = sc.nextInt();
        int[] A = new int[n];

        System.out.println("Enter the elements of Array:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        Merge m = new Merge();

        m.mergesort(A, 0, n - 1);

        System.out.println("Sorted Array:");
        m.printArray(A);
    }
}
