package DATA_STRUCTURES;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
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
        if (index > 0 && heap[parentIndex] > heap[index]) {
            swap(parentIndex, index);
            heapifyUp(parentIndex);
        }
    }

    private void heapifyDown(int index) {
        int minIndex = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] < heap[minIndex]) {
            minIndex = left;
        }
        if (right < size && heap[right] < heap[minIndex]) {
            minIndex = right;
        }

        if (minIndex != index) {
            swap(index, minIndex);
            heapifyDown(minIndex);
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

    public int extractMin() {
        if (size <= 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return min;
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(15);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(45);

        System.out.println("Heap elements:");
        minHeap.printHeap();

        System.out.println("Extracted min: " + minHeap.extractMin());
        System.out.println("Heap after extracting min:");
        minHeap.printHeap();
    }
}
