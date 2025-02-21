package DATA_STRUCTURES;

public class Queue_Array {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int size;

    public Queue_Array(int maxSize) {
        this.maxSize = maxSize;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element " + element);
            return;
        }
        rear = (rear + 1) % maxSize;
        queueArray[rear] = element;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }
        int element = queueArray[front];
        front = (front + 1) % maxSize;
        size--;
        return element;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1;
        }
        return queueArray[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        int count = 0;
        int index = front;
        while (count < size) {
            System.out.print(queueArray[index] + " ");
            index = (index + 1) % maxSize;
            count++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue_Array queueArray = new Queue_Array(5);

        queueArray.enqueue(1);
        queueArray.enqueue(2);
        queueArray.enqueue(3);
        queueArray.enqueue(4);
        queueArray.display(); // Output: Queue: 1 2 3 4

        System.out.println("Dequeued element: " + queueArray.dequeue()); // Output: Dequeued element: 1
        queueArray.display(); // Output: Queue: 2 3 4

        System.out.println("Peeked element: " + queueArray.peek()); // Output: Peeked element: 2
    }
}
