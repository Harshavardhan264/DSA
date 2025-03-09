public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    public void insert(int element) {
        if (size == capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = element;
        size++;
        heapifyUp(size - 1);
    }
    private void heapifyUp(int i) {
        while (i > 0 && heap[parent(i)] < heap[i]) {  // Parent should be greater
            int temp = heap[parent(i)];
            heap[parent(i)] = heap[i];
            heap[i] = temp;
            i = parent(i);
        }
    }
    public void deleteMax() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return;
        }
        if (size == 1) {
            size--;
            return;
        }

        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0); 
    }

    // Heapify Down for Max Heap
    private void heapifyDown(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            heapifyDown(largest);
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);
        maxHeap.insert(40);

        System.out.println("Max Heap:");
        maxHeap.printHeap();

        System.out.println("Deleting the maximum element (root)...");
        maxHeap.deleteMax();

        System.out.println("Max Heap after deletion:");
        maxHeap.printHeap();
    }
}
