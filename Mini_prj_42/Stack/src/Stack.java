import java.util.Arrays;

public class Stack {
    private int length;
    private int top;
    private int[] stackArray;
    char[] list =new char[];

    public Stack(int size) {
        length = size;
        stackArray = new int[length];
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == length - 1);
    }

    public void push(int value) {
        if (!isFull()) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack is full");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }
    public int peek() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }
    public void checkValid(){

    }
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack: " + Arrays.toString(stack.stackArray));
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
    }
}