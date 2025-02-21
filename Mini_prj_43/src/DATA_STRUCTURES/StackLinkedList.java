package DATA_STRUCTURES;

class NodeStack {
    int data;
    NodeStack next;

    NodeStack(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackLinkedList {
    private NodeStack top;

    public StackLinkedList() {
        this.top = null;
    }

    public void push(int data) {
        NodeStack newNodeStack = new NodeStack(data);
        if (top == null) {
            top = newNodeStack;
        } else {
            newNodeStack.next = top;
            top = newNodeStack;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek element.");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        NodeStack current = top;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display(); // Output: Stack: 3 2 1

        System.out.println("Popped element: " + stack.pop()); // Output: Popped element: 3
        stack.display(); // Output: Stack: 2 1

        System.out.println("Peeked element: " + stack.peek()); // Output: Peeked element: 2
    }
}
