package DATA_STRUCTURES;

class NodeQueue {
    int data;
    NodeQueue next;

    NodeQueue(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueLinkedList {
    private NodeQueue front;
    private NodeQueue rear;

    public QueueLinkedList() {
        this.front = null;
        this.rear = null;
    }

    public void enqueue(int data) {
        NodeQueue newNodeQueue = new NodeQueue(data);
        if (isEmpty()) {
            front = newNodeQueue;
            rear = newNodeQueue;
        } else {
            rear.next = newNodeQueue;
            rear = newNodeQueue;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue element.");
            return -1;
        }
        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1;
        }
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        NodeQueue current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLinkedList queue = new QueueLinkedList();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.display(); // Output: Queue: 1 2 3 4

        System.out.println("Dequeued element: " + queue.dequeue()); // Output: Dequeued element: 1
        queue.display(); // Output: Queue: 2 3 4

        System.out.println("Peeked element: " + queue.peek()); // Output: Peeked element: 2
    }
}
