package DATA_STRUCTURES;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void heapifyUp(int index) {
        int parentIndex = parent(index);
        if (index > 0 && heap[parentIndex] < heap[index]) {
            swap(parentIndex, index);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int maxIndex = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] > heap[maxIndex]) {
            maxIndex = left;
        }
        if (right < size && heap[right] > heap[maxIndex]) {
            maxIndex = right;
        }

        if (maxIndex != index) {
            swap(index, maxIndex);
            heapifyDown(maxIndex);
        }
    }

    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Heap is full");
            return;
        }
        heap[size] = value;
        heapifyUp(size);
        size++;
    }

    public int extractMax() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(3);
        maxHeap.insert(2);
        maxHeap.insert(1);
        maxHeap.insert(15);
        maxHeap.insert(5);
        maxHeap.insert(4);
        maxHeap.insert(45);

        System.out.println("Heap elements:");
        maxHeap.printHeap();

        System.out.println("Extracted max: " + maxHeap.extractMax());
        System.out.println("Heap after extracting max:");
        maxHeap.printHeap();
    }
}
