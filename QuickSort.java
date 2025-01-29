import java.util.*;

class QuickSort {
    int partition(int a[], int low, int high) {
        int pivot = a[low]; 
        int i = low + 1;
        int j = high;

        while (i <= j) {

            while (i <= high && a[i] <= pivot) {
                i++;
            }

            while (a[j] > pivot) {
                j--;
            }

            if (i < j) {
                interchange(a, i, j);
            }
        }

        interchange(a, low, j);
        return j; 
    }

    void interchange(int a[], int low, int high) {
        int temp = a[low];
        a[low] = a[high];
        a[high] = temp;
    }
    void quicksort(int a[], int low, int high) {
        if (low < high) {
            int j = partition(a, low, high);  
            quicksort(a, low, j - 1);         
            quicksort(a, j + 1, high);        
        }
    }

    void printArray(int a[]) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the No.of elements:");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter the elements of Array:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        QuickSort q = new QuickSort();

        q.quicksort(a, 0, n - 1);
        System.out.println("Sorted Array:");
        q.printArray(a);
    }
}
