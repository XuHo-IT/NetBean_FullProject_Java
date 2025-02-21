package DATA_STRUCTURES;

public class Stack_Array {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack_Array(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];
        this.top = -1;
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack overflow. Cannot push element " + element);
            return;
        }
        stackArray[++top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop element.");
            return -1;
        }
        return stackArray[top--];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek element.");
            return -1;
        }
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack_Array stackArray = new Stack_Array(5);

        stackArray.push(1);
        stackArray.push(2);
        stackArray.push(3);
        stackArray.display(); // Output: Stack: 1 2 3

        System.out.println("Popped element: " + stackArray.pop()); // Output: Popped element: 3
        stackArray.display(); // Output: Stack: 1 2

        System.out.println("Peeked element: " + stackArray.peek()); // Output: Peeked element: 2
    }
}
