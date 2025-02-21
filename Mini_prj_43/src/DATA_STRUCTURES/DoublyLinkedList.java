package DATA_STRUCTURES;

class NodeDoubly {
    int data;
    NodeDoubly prev;
    NodeDoubly next;

    NodeDoubly(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    private NodeDoubly head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public void append(int data) {
        NodeDoubly newNode = new NodeDoubly(data);
        if (head == null) {
            head = newNode;
            return;
        }
        NodeDoubly lastNodeDoubly = head;
        while (lastNodeDoubly.next != null) {
            lastNodeDoubly = lastNodeDoubly.next;
        }
        lastNodeDoubly.next = newNode;
        newNode.prev = lastNodeDoubly;
    }

    public void prepend(int data) {
        NodeDoubly newNode = new NodeDoubly(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void deleteNode(int key) {
        NodeDoubly temp = head;

        if (temp != null && temp.data == key) {
            head = temp.next;
            head.prev = null;
            return;
        }

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) return;

        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    public void displayForward() {
        NodeDoubly current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        NodeDoubly current = head;
        while (current != null && current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.displayForward(); // Output: 1 <-> 2 <-> 3 <-> 4 <-> null
        linkedList.displayBackward(); // Output: 4 <-> 3 <-> 2 <-> 1 <-> null

        linkedList.prepend(0);
        linkedList.displayForward(); // Output: 0 <-> 1 <-> 2 <-> 3 <-> 4 <-> null
        linkedList.displayBackward(); // Output: 4 <-> 3 <-> 2 <-> 1 <-> 0 <-> null

        linkedList.deleteNode(2);
        linkedList.displayForward(); // Output: 0 <-> 1 <-> 3 <-> 4 <-> null
        linkedList.displayBackward(); // Output: 4 <-> 3 <-> 1 <-> 0 <-> null
    }
}
